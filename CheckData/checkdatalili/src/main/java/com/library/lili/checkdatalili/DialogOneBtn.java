package com.library.lili.checkdatalili;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.library.lili.checkdatalili.listener.YesListener;


/**
 * Created by lili on 15/4/21.
 */
public class DialogOneBtn extends Dialog implements
        View.OnClickListener {

    public Activity mActivity;
    public Dialog mDialog;
    public Button btnContinue;
    public String StrTitle;
    public String StrContext;
    public String StrButton;

    YesListener yesListener = null;

    public DialogOneBtn(Activity mActivity, String StrTitle, String StrContext) {
        super(mActivity);
        this.mActivity = mActivity;
        this.StrTitle = StrTitle;
        this.StrContext = StrContext;
        this.StrButton=mActivity.getString(R.string.register_confirm);
    }

    public DialogOneBtn(Activity mActivity, String StrTitle, String StrContext, YesListener yesListener) {
        super(mActivity);
        this.mActivity = mActivity;
        this.StrTitle = StrTitle;
        this.StrContext = StrContext;
        this.StrButton=mActivity.getString(R.string.register_confirm);
        this.yesListener = yesListener;
    }

    public DialogOneBtn(Activity mActivity, String StrTitle, String StrContext, String StrButton, YesListener yesListener) {
        super(mActivity);
        this.mActivity = mActivity;
        this.StrTitle = StrTitle;
        this.StrContext = StrContext;
        this.StrButton = StrButton;
        this.yesListener = yesListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.view_dialog_one);
        TextView txtcontext = (TextView) findViewById(R.id.txtNewContext);
        TextView txtTitle = (TextView) findViewById(R.id.txtNewTitle);
        btnContinue = (Button) findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(this);

        btnContinue.setText(StrButton);
        txtTitle.setText(StrTitle);
        txtcontext.setText(StrContext);

    }

    @Override
    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.btnContinue) {
            if (yesListener != null) {
                yesListener.clickYes();
            }

        } else {
        }
        dismiss();
    }
}