package com.fortests.meet5practice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment2 extends Fragment {
    private Button mButton;

    OnButtonPressedListener mCallback;

    public interface OnButtonPressedListener{
        public void onButtonPressed();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment2,container,false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initViews(view);
        initListeners();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mCallback = (OnButtonPressedListener)context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() + "must implement OnButtonPressedListener");
        }

    }

    private void initViews(View view) {
        mButton = view.findViewById(R.id.fragment_2_button);
    }

    private void initListeners() {
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment3 = Fragment3.newInstance();
                FragmentManager manager = getChildFragmentManager();
                if (manager.findFragmentById(R.id.fragment_3_container)==null){
                    manager.beginTransaction().add(R.id.fragment_3_container,fragment3).commit();
                } else {
                    //without interface
                    //changeFragment3Textview();

                    //with interface
                    mCallback.onButtonPressed();
                }


            }
        });
    }

    private void changeFragment3Textview() {
        ((MainActivity)getActivity()).pressButton();
    }
}
