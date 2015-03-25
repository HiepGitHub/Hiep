package com.sss.linkboard.ui.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sss.linkboard.R;
import com.sss.linkboard.util.Utils;


public class HeaderSearchView extends FrameLayout{

    public interface HeaderSearchViewDelegate{
        public void HeaderSearchView_TouchMoreButton();
        public void HeaderSearchView_TouchSearch(String searchText);
        public void HeaderSearchView_TouchWebTab();
        public void HeaderSearchView_TouchSocialTab();
    }


    private EditText edSearch;
    private TextView tvSearch;
    private ImageView imvMore;

    private Button tvTabWeb;
    private Button tvTabSocial;

    private HeaderSearchViewDelegate delegate;

    public void setDelegate(HeaderSearchViewDelegate delegate) {
        this.delegate = delegate;
    }

    public HeaderSearchView(Context context) {
        this(context, null, 0);
    }

    public HeaderSearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeaderSearchView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.include_input_search, this, true);

        findViewById(R.id.re_main_container).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.hideKeyboard(getContext(), edSearch);
            }
        });

        edSearch = (EditText) findViewById(R.id.edtInputSearch);
        tvSearch = (TextView) findViewById(R.id.tvResultInPut);
        imvMore = (ImageView) findViewById(R.id.btnMore);

        tvTabWeb = (Button) findViewById(R.id.tabWeb);
        tvTabSocial = (Button) findViewById(R.id.tabSocial);

        tvTabWeb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (delegate == null){
                    return;
                }

                if (tvTabWeb.isSelected()){
                    return;
                }

                tvTabWeb.setSelected(true);
                tvTabSocial.setSelected(false);

                delegate.HeaderSearchView_TouchWebTab();

            }
        });

        tvTabSocial.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (delegate == null){
                    return;
                }

                if (tvTabSocial.isSelected()){
                    return;
                }

                tvTabSocial.setSelected(true);
                tvTabWeb.setSelected(false);

                delegate.HeaderSearchView_TouchSocialTab();
            }
        });

        imvMore.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (delegate == null){
                    return;
                }

                delegate.HeaderSearchView_TouchMoreButton();
            }
        });

        edSearch.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    if (delegate != null){
                        Utils.hideKeyboard(getContext(), edSearch);
                        delegate.HeaderSearchView_TouchSearch(v.getText().toString());
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public void setLabelText(String text){
        tvSearch.setText("'" + text + "'");
    }

    public void setEditorText(String text){
        edSearch.setText(text);
    }

    public void setSelectIndex(int index){

        if (delegate == null){
            return;
        }


        if (index == 0){
            tvTabWeb.setSelected(true);
            tvTabSocial.setSelected(false);
            delegate.HeaderSearchView_TouchWebTab();
        }else{
            tvTabWeb.setSelected(false);
            tvTabSocial.setSelected(true);
            delegate.HeaderSearchView_TouchSocialTab();
        }
    }

}
