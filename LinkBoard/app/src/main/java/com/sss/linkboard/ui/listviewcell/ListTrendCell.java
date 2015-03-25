package com.sss.linkboard.ui.listviewcell;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sss.linkboard.R;
import com.sss.linkboard.service.client.TrendingItem;


public class ListTrendCell extends LinearLayout{

    private Context mContext;
    private TextView tvTrend;

    public ListTrendCell(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private void init(){
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_list_trend,this,true);
        tvTrend = (TextView) this.findViewById(R.id.tvTrend);
    }

    public void setData(TrendingItem item){
        tvTrend.setText(item.getTitle());
    }

}
