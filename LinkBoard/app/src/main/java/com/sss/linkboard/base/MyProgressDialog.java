package com.sss.linkboard.base;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;

import com.sss.linkboard.R;

public class MyProgressDialog extends Dialog{

    public MyProgressDialog(Context context) {
        super(context,android.R.style.Theme_Translucent);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setContentView(R.layout.custom_progress_dialog);
    }

    @Override
    public boolean onSearchRequested() {
        return false;
    }
}
