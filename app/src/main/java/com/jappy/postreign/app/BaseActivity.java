package com.jappy.postreign.app;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jappy.postreign.R;


/**
 * Created by jappy on 08-08-17.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        mProgressDialog = new ProgressDialog(this);
        init();
    }

    public void showToast(String message) {
        Toast.makeText(this, String.valueOf(message), Toast.LENGTH_SHORT).show();
    }


    public void showProgressDialog(boolean cancel) {
        mProgressDialog.setMessage(getString(R.string.please_wait));
        if (mProgressDialog != null && !mProgressDialog.isShowing()) {
            mProgressDialog.show();
            mProgressDialog.setCancelable(cancel);
        }
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    public abstract void init();

    public abstract void setContentView();

    public abstract void checkPermission();
}
