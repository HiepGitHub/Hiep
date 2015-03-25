package com.sss.linkboard.ui.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import com.sss.linkboard.service.client.bing.Bing;
import com.sss.linkboard.service.network.VolleySingleton;
import com.sss.linkboard.ui.WebViewActivity;


public class BingAdapter extends BaseAdapter {
    private Context mContext;
    private Bing bing;
    private LayoutInflater mLayoutInflater;

    private ListView listView;

    public void setListView(ListView view) {
        listView = view;
    }

    public BingAdapter(Context context, Bing bing) {
        super();
        this.mContext = context;
        this.bing = bing;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    public BingAdapter(Context context) {
        super();
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return (bing == null) ? 0 : bing.getD().getResults().size();
    }

    @Override
    public Object getItem(int position) {
        Bing.BingResult bingResult = bing.getD().getResults().get(position);
        return bingResult;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
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

//        final int myPosition = position;
//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bing.BingResult bingResult = (Bing.BingResult) getItem(myPosition);
//                Bundle bundle = new Bundle();
//                bundle.putString(WebViewActivity.BUNDLE_EXTRA_SOURCE,bingResult.getUrl());
//                WebViewActivity.startWebViewActivity(mContext,bundle);
//            }
//        });

        Bing.BingResult result = bing.getD().getResults().get(position);
        holder.tvBingTitle.setText(result.getTitle());
        holder.tvBingUser.setText(result.getSource());
        holder.tvTimeStamp.setText(result.getDate());
        holder.tvBingContent.setText(result.getDescription());
        holder.ivBingProfile.setImageUrl(result.getUrl(), VolleySingleton.getInstance(mContext).getImageLoader());
        return view;
    }

    public static class ViewHolder {
        LinearLayout mainView;
        LinearLayout mainPopupView;
        TextView tvBingTitle;
        TextView tvTimeStamp;
        TextView tvBingContent;
        TextView tvBingUser;
        NetworkImageView ivBingProfile;
    }

    public void setList(Bing bing) {
        this.bing = bing;
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
                        }else{
                            if (!mode) {
                                swipe(0);
                            }
                        }
                    } else {
                        if (!mode){
                            Bing.BingResult bingResult = (Bing.BingResult) getItem(position);
                            Bundle bundle = new Bundle();
                            bundle.putString(WebViewActivity.BUNDLE_EXTRA_SOURCE,bingResult.getUrl());
                            WebViewActivity.startWebViewActivity(mContext,bundle);
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
                    if (!mode){
                        holder.mainPopupView.setVisibility(View.GONE);
                    }else{
                        holder.mainPopupView.setVisibility(View.VISIBLE);
                    }
                    return false;
            }

            return true;
        }

        private void swipe(int distance) {
            if (!mode){
                holder.mainPopupView.setVisibility(View.GONE);
            }else{
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
