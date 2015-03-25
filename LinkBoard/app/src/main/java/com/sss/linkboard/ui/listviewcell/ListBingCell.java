package com.sss.linkboard.ui.listviewcell;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.sss.linkboard.R;


public class ListBingCell extends LinearLayout {

    private Context mContext;
    private TextView tvBingTitle;
    private TextView tvTimeStamp;
    private TextView tvBingContent;
    private TextView tvBingUser;
    private NetworkImageView ivBingProfile;



    public ListBingCell(Context context) {
        super(context);
        this.mContext = context;
    }

    private void init(){
        LayoutInflater  inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_list_bing,this,true);
        ivBingProfile = (NetworkImageView) this.findViewById(R.id.ivBingProfile);
        tvBingTitle = (TextView) this.findViewById(R.id.tvBingTitle);
        tvTimeStamp = (TextView) this.findViewById(R.id.tvBingTimeStamp);
        tvBingUser = (TextView) this.findViewById(R.id.tvBingUserName);
        tvBingContent = (TextView) this.findViewById(R.id.tvBingContent);
    }
}
