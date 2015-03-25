package com.sss.linkboard.base;

import android.content.DialogInterface;
import android.view.WindowManager;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.sss.linkboard.R;


public class BaseActivity extends SherlockFragmentActivity{

    private MyProgressDialog mProgress;

    @Override
    protected void onStop() {
        super.onStop();
        keepScreenOn(false);
        if (mProgress != null) {
            if (isFinishing())
                mProgress.cancel();
            else
                mProgress.dismiss();
        }
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        keepScreenOn(false);
        if (mProgress != null)
            mProgress.cancel();
    }

    public final void startProgress() {
        startProgress(getString(R.string.progress_dialog_message));
    }

    private void startProgress(CharSequence message) {
        if (mProgress == null) {
            mProgress = new MyProgressDialog(this);
            mProgress.setCanceledOnTouchOutside(false);
        }
        mProgress.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                keepScreenOn(false);
                abort(true);
            }
        });
        mProgress.show();
    }

    protected void stopServiceAndResource(){

    }

    protected final void abort(boolean stopService) {
        if (mProgress != null) {
            mProgress.dismiss();
            mProgress = null;
        }
        if (stopService) {
            stopServiceAndResource();
        }
    }

    private void keepScreenOn(boolean active) {
        if (active)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        else
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

}
