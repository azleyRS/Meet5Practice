package com.fortests.meet5practice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment3 extends Fragment {
    public TextView mTextView;

    private static Fragment3 mFragment3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment3,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mTextView = view.findViewById(R.id.fragment_3_text_view);
        if (savedInstanceState != null){
            mTextView.setText(savedInstanceState.getString("textviewText"));
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textviewText",mTextView.getText().toString());
    }


    public static Fragment newInstance() {
        if (mFragment3 == null){
            mFragment3 = new Fragment3();
            Log.d("TAG","Created fragment instance");
        } else {
            Log.d("TAG","Returned fragment");
            return mFragment3;
        }

        return mFragment3;
    }
}
