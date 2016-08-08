package com.example.pedro.inyecciondependencias.otherviews;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.pedro.inyecciondependencias.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pedro on 8/08/16.
 */
public class CustomDialog extends Dialog {

    public CustomDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.inflate_dialog, null);
        ButterKnife.bind(this, view);
        setContentView(view);
    }

    @OnClick({R.id.b_dialog_si, R.id.b_dialog_no})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.b_dialog_si:
                dismiss();
                break;
            case R.id.b_dialog_no:
                break;
            default:
                break;
        }
    }
}
