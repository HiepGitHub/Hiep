package com.sss.linkboard.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sss.linkboard.R;
import com.sss.linkboard.base.BaseFragment;
import com.sss.linkboard.local.model.SettingSocialSearchModel;

import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.OnWheelChangedListener;
import antistatic.spinnerwheel.WheelHorizontalView;
import antistatic.spinnerwheel.adapters.ArrayWheelAdapter;

public class SettingSocialFragment extends BaseFragment {
    public static SettingSocialFragment createInstance(Bundle bundle) {
        SettingSocialFragment fragment = new SettingSocialFragment();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    public interface SettingSocialFragmentDelegate {

    }

    private WheelHorizontalView wheelHorizontalView;
    private ViewPager mViewPager;

    private int defaultIndex = 2;

    private int[] resCate = new int[]{R.string.web_setting_title_sort_by, R.string.web_setting_title_type,R.string.web_setting_title_search_term
            ,R.string.web_setting_title_date_post};

    private static String[] categories;
    private static String[] getCategories(Context context, int[] res){
        if (categories == null){
            categories = new String[res.length];
            for (int i = 0  ; i < res.length ; i++){
                categories[i] = context.getString(res[i]);
            }
        }
        return categories;
    }

    private SettingSocialFragmentDelegate delegate;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        delegate = (SettingSocialFragmentDelegate) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        delegate = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_web_setting, container, false);
        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(new ContentPagerAdapter());
        mViewPager.setOffscreenPageLimit(resCate.length);

        wheelHorizontalView = (WheelHorizontalView) view.findViewById(R.id.slide_category);
        ArrayWheelAdapter adapter = new ArrayWheelAdapter(getActivity(),getCategories(getActivity(),resCate));
        adapter.setItemResource(R.layout.wheel_text_centered_category);
        adapter.setItemTextResource(R.id.text);
        wheelHorizontalView.setViewAdapter(adapter);
        wheelHorizontalView.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(AbstractWheel wheel, int oldValue, int newValue) {
                mViewPager.setCurrentItem(newValue);
            }
        });

        mViewPager.setCurrentItem(defaultIndex);
        wheelHorizontalView.setCurrentItem(defaultIndex);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    class ContentPagerAdapter extends PagerAdapter {

        /**
         * @return the number of pages to display
         */
        @Override
        public int getCount() {
            return resCate.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return o == view;
        }


        @Override
        public CharSequence getPageTitle(int position) {
            int res = 0;
            switch (position){
                case 0:
                    res = R.string.web_setting_title_sort_by;
                    break;
                case 1:
                    res = R.string.web_setting_title_type;
                    break;
                case 2:
                    res = R.string.web_setting_title_search_term;
                    break;
                case 3:
                    res = R.string.web_setting_title_date_post;
                    break;
            }

            return getString(res);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = getActivity().getLayoutInflater().inflate(R.layout.widget_social_setting_search_terms,
                    container, false);
            container.addView(view);

            final EditText edAll = (EditText) view.findViewById(R.id.ed_all_of);
            final EditText edAny = (EditText) view.findViewById(R.id.ed_any_of);
            final EditText edNone = (EditText) view.findViewById(R.id.ed_none_of);
            final EditText edExact = (EditText) view.findViewById(R.id.ed_this_exact);
            final EditText edFrom = (EditText) view.findViewById(R.id.ed_from_these);
            final EditText edTo = (EditText) view.findViewById(R.id.ed_to_these);
            final EditText edMention = (EditText) view.findViewById(R.id.ed_mentioning);

            if (position == defaultIndex){
                SettingSocialSearchModel model = SettingSocialSearchModel.getInstance(getActivity());
                edAll.setText(model.getTwitterAll());
                edAny.setText(model.getTwitterAny());
                edNone.setText(model.getTwitterNone());
                edExact.setText(model.getTwitterExact());
                edFrom.setText(model.getTwitterFrom());
                edTo.setText(model.getTwitterTo());
                edMention.setText(model.getTwitterMention());
            }

            final Button buttonSave = (Button) view.findViewById(R.id.bt_save_change);
            buttonSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String all = getStringEditText(edAll);
                    String any = getStringEditText(edAny);
                    String none = getStringEditText(edNone);
                    String exact = getStringEditText(edExact);
                    String from = getStringEditText(edFrom);
                    String to = getStringEditText(edTo);
                    String mention = getStringEditText(edMention);
                    SettingSocialSearchModel.getInstance(getActivity()).saveToLocal(all, any, none, exact, "", from, to, mention, "");
                    Toast.makeText(getActivity(), getString(R.string.save_success), Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }


    private String getStringEditText(EditText editText) {
        return editText.getText().toString();
    }
}