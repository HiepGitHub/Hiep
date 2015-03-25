package com.sss.linkboard.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.sss.linkboard.service.client.TrendingItem;
import com.sss.linkboard.ui.listviewcell.ListTrendCell;


public class TrendingAdapter extends BaseAdapter{

    private Context mContext;

    private TrendingItem[] list;

    public TrendingAdapter(Context context){
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return list==null?0:list.length;
    }

    @Override
    public Object getItem(int position) {
        return list[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListTrendCell cell = (ListTrendCell) convertView;
        if (cell ==null){
            cell = new ListTrendCell(mContext);
        }
        cell.setData(list[position]);
        return cell;
    }


    public void setList(TrendingItem[] list){
        this.list = list;
        notifyDataSetChanged();
    }

    public TrendingItem getItemAtIndex(int index){
        return list[index];
    }
}
