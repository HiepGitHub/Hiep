package com.sss.linkboard.ui;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;
import com.sss.linkboard.ui.adapter.SlidingRightMenuAdapter;
import com.sss.linkboard.ui.model.MenuSettingModel;

import java.util.ArrayList;


public class RightMenuFragment extends BaseFragment{

    private ListView lvRightMenu;
    private SlidingRightMenuAdapter adapter;
    private ArrayList<MenuSettingModel> listMenus;

    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    public interface RightMenuFragmentDelegate{
        public void onDidTouchMenu();
    }

    private RightMenuFragmentDelegate delegate;

    public static RightMenuFragment createInstance(Bundle bundle){
        RightMenuFragment fragment = new RightMenuFragment();
        if (bundle!=null){
            fragment.setArguments(bundle);
        }
        return fragment;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        delegate = (RightMenuFragmentDelegate) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        delegate = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right_menu,container,false);
        lvRightMenu = (ListView) view.findViewById(R.id.list_right);
        lvRightMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        BlankActivity.startBlankActivity(getActivity());
                        break;
                    case 1:
                        ProfileActivity.startProfileActivity(getActivity());
                        break;
                    case 2:
                        BlankActivity.startBlankActivity(getActivity());
                        break;
                    case 3:
                        BlankActivity.startBlankActivity(getActivity());
                        break;
                    case 4:
                        BlankActivity.startBlankActivity(getActivity());
                        break;
                    case 5:
                        break;
                }

                if (delegate != null){
                    delegate.onDidTouchMenu();
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new SlidingRightMenuAdapter(getActivity());
        listMenus = new ArrayList<MenuSettingModel>();
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        navMenuIcons = getResources().obtainTypedArray(R.array.nav_drawer_icons);

        listMenus.add(new MenuSettingModel(navMenuTitles[0],navMenuIcons.getResourceId(0,-1)));
        listMenus.add(new MenuSettingModel(navMenuTitles[1],navMenuIcons.getResourceId(1,-1)));
        listMenus.add(new MenuSettingModel(navMenuTitles[2],navMenuIcons.getResourceId(2,-1)));
        listMenus.add(new MenuSettingModel(navMenuTitles[3],navMenuIcons.getResourceId(3,-1)));
        listMenus.add(new MenuSettingModel(navMenuTitles[4],navMenuIcons.getResourceId(4,-1)));
        listMenus.add(new MenuSettingModel(navMenuTitles[5],navMenuIcons.getResourceId(5,-1)));
        adapter.setListMenu(listMenus);
        lvRightMenu.setAdapter(adapter);
    }
}
