package com.sss.linkboard.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sss.linkboard.R;
import com.sss.linkboard.ui.model.MenuSettingModel;

import java.util.ArrayList;


public class SlidingRightMenuAdapter extends BaseAdapter{

    private Context mContext;
    private ArrayList<MenuSettingModel> listMenus;

    public SlidingRightMenuAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return (listMenus==null)?0:listMenus.size();
    }

    @Override
    public Object getItem(int position) {
        return listMenus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = null;
        if (convertView==null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_list_menu_setting,null);

            holder = new Holder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.title);
            holder.ivIcon = (ImageView) convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        MenuSettingModel model = listMenus.get(position);
        holder.ivIcon.setImageResource(model.getIcon());
        if (position == listMenus.size() - 1){
            holder.ivIcon.setVisibility(View.INVISIBLE);
        }else{
            holder.ivIcon.setVisibility(View.VISIBLE);
        }
        holder.tvTitle.setText(model.getTitle());

        return convertView;
    }

    static class Holder{
        public ImageView ivIcon;
        public TextView tvTitle;
    }

    public void setListMenu(ArrayList<MenuSettingModel> list){
        this.listMenus = list;
        notifyDataSetChanged();
    }
}
