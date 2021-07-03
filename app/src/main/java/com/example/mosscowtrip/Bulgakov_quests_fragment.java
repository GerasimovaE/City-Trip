package com.example.mosscowtrip;

import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class Bulgakov_quests_fragment extends Fragment {

    DialogFragment dlg1;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.bulgakov_fragment1, null);

        TextView text1 = (TextView) v.findViewById(R.id.fragment_bulgakov_text1);
        text1.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        TextView text2 = (TextView) v.findViewById(R.id.fragment_bulgakov_text2);
        text2.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);

        EditText result = (EditText) v.findViewById(R.id.result1);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg1 = new Dialog();
                dlg1.show(getFragmentManager().beginTransaction(), "dlg1");
            }
        });

        return v;
    }
}
