package com.sss.linkboard.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.sss.linkboard.R;
import com.sss.linkboard.service.client.tweet.Tweet;
import com.sss.linkboard.service.client.tweet.TweetTemp;
import com.sss.linkboard.service.network.VolleySingleton;
import com.sss.linkboard.ui.DetailTweetActivity;


public class SocialAdapter extends BaseAdapter {
    private Context mContext;
    private Tweet[] items;
    private LayoutInflater mLayoutInflater;

    private ListView listView;

    public void setListView(ListView view) {
        listView = view;
    }


    public SocialAdapter(Context context, Tweet[] items) {
        super();
        this.mContext = context;
        this.items = items;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public SocialAdapter(Context context) {
        super();
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return (items == null) ? 0 : items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        View view = convertView;
        if (view == null) {

            view = mLayoutInflater.inflate(R.layout.item_list_bing, parent, false);
            holder = new ViewHolder();

            holder.mainPopupView = (LinearLayout) view.findViewById(R.id.main_popup);
            holder.mainView = (LinearLayout) view.findViewById(R.id.main_view);
            holder.tvBingTitle = (TextView) view.findViewById(R.id.tvBingTitle);
            holder.tvBingUser = (TextView) view.findViewById(R.id.tvBingUserName);
            holder.tvTimeStamp = (TextView) view.findViewById(R.id.tvBingTimeStamp);
            holder.tvBingContent = (TextView) view.findViewById(R.id.tvBingContent);
            holder.ivBingProfile = (NetworkImageView) view.findViewById(R.id.ivBingProfile);

            holder.ivBingProfile.setErrorImageResId(R.drawable.no_image);
            holder.ivBingProfile.setDefaultImageResId(R.drawable.no_image);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.mainView.getLayoutParams();
        params.rightMargin = 0;
        params.leftMargin = 0;
        holder.mainView.setLayoutParams(params);
        view.setOnTouchListener(new SwipeDetector(holder, position));
        holder.mainPopupView.setVisibility(View.GONE);

        final Tweet tweet = items[position];
        holder.tvBingTitle.setText(tweet.getText());
        holder.tvBingUser.setText(tweet.getUser().getName());
        holder.tvTimeStamp.setText(tweet.getCreated_at());
        holder.tvBingContent.setText(tweet.getUser().getDescription());

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TweetTemp temp = new TweetTemp("Remains of Richard III arrive at final resting place ahead of burial via the @FoxNews App http://t.co/35RHBwWlU8",
//                        "Jennifer Richey","Mon Mar 23 15:30:05 +0000 2015","Member of the video ministry team at First Baptist Church - Tupelo, MS. To listen or watch the sermons, log on to http://t.co/H4885pUJ3s & click on sermons",
//                        "http://pbs.twimg.com/profile_images/528784080561664000/_g8Pcpcd_normal.jpeg");
//                Bundle bundle = new Bundle();
//                bundle.putParcelable(DetailTweetActivity.BUNDLE_EXTRA_TWEET, temp);
//                DetailTweetActivity.startDetailActivity(mContext, bundle);
//            }
//        });

        holder.ivBingProfile.setImageUrl(tweet.getUser().getProfile_image_url(), VolleySingleton.getInstance(mContext).getImageLoader());
        return view;
    }

    public static class ViewHolder {
        LinearLayout mainView;
        LinearLayout mainPopupView;

        ViewGroup vgSave;
        ViewGroup vgShare;

        TextView tvBingTitle;
        TextView tvTimeStamp;
        TextView tvBingContent;
        TextView tvBingUser;
        NetworkImageView ivBingProfile;
    }

    public void setList(Tweet[] items) {
        this.items = items;
        notifyDataSetChanged();
    }


    public class SwipeDetector implements View.OnTouchListener {

        private static final int MIN_DISTANCE = 300;
        private static final int MIN_LOCK_DISTANCE = 30; // disallow motion intercept
        private boolean motionInterceptDisallowed = false;
        private float downX, upX;
        private ViewHolder holder;
        private int position;
        private boolean mode = false;

        public SwipeDetector(ViewHolder h, int pos) {
            holder = h;
            position = pos;
        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN: {
                    downX = event.getX();
                    return true; // allow other events like Click to be processed
                }

                case MotionEvent.ACTION_MOVE: {
                    if (!mode) {
                        upX = event.getX();
                        float deltaX = downX - upX;

                        if (Math.abs(deltaX) > MIN_LOCK_DISTANCE && listView != null && !motionInterceptDisallowed) {
                            listView.requestDisallowInterceptTouchEvent(true);
                            motionInterceptDisallowed = true;
                        }

                        if (deltaX > 0) {
                            holder.mainPopupView.setVisibility(View.GONE);
                        } else {
                            // if first swiped left and then swiped right
                            holder.mainPopupView.setVisibility(View.VISIBLE);
                        }

                        if (deltaX > 0) {
                            swipe(-(int) deltaX);
                        }
                    }
                    return true;
                }

                case MotionEvent.ACTION_UP:
                    upX = event.getX();
                    float deltaX = upX - downX;
                    if (Math.abs(deltaX) > MIN_DISTANCE) {
                        // left or right
                        if (deltaX < 0) {
                            mode = true;
                            int sizePopup = mContext.getResources().getDimensionPixelSize(R.dimen.popup_size_width);
                            swipe(-sizePopup);
                        } else {
                            if (!mode) {
                                swipe(0);
                            }
                        }
                    } else {
                        if (!mode){
                            Tweet tweet = items[position];
                            TweetTemp temp = new TweetTemp(tweet.getText(),
                                    tweet.getUser().getName(),tweet.getCreated_at(),tweet.getUser().getDescription(),
                                    tweet.getUser().getProfile_image_url());
                            Bundle bundle = new Bundle();
                            bundle.putParcelable(DetailTweetActivity.BUNDLE_EXTRA_TWEET, temp);
                            DetailTweetActivity.startDetailActivity(mContext, bundle);
                        }
                        mode = false;
                        swipe(0);
                    }

                    if (listView != null) {
                        listView.requestDisallowInterceptTouchEvent(false);
                        motionInterceptDisallowed = false;
                    }

                    return true;

                case MotionEvent.ACTION_CANCEL:
                    if (!mode) {
                        holder.mainPopupView.setVisibility(View.GONE);
                    } else {
                        holder.mainPopupView.setVisibility(View.VISIBLE);
                    }
                    return false;
            }

            return true;
        }

        private void swipe(int distance) {
            if (!mode) {
                holder.mainPopupView.setVisibility(View.GONE);
            } else {
                holder.mainPopupView.setVisibility(View.VISIBLE);
            }
            View animationView = holder.mainView;
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) animationView.getLayoutParams();
            params.rightMargin = -distance;
            params.leftMargin = distance;
            animationView.setLayoutParams(params);
        }
    }

}
