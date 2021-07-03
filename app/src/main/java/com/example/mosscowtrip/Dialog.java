package com.example.mosscowtrip;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class Dialog extends DialogFragment implements View.OnClickListener {

    final String LOG_TAG = "myLogs";
    int style = DialogFragment.STYLE_NO_TITLE;
    int theme = R.style.MyDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setStyle(style, theme);
        getDialog().setTitle("Title");
        View v = inflater.inflate(R.layout.dialog, null);
        v.findViewById(R.id.btnOK).setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        Log.d(LOG_TAG, "Dialog: " + ((Button)v).getText());
        dismiss();
    }

    @Override
    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog: onDismiss");
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog: onCancel");
    }
}
