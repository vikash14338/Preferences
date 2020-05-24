package com.example.gogagapreferences;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Switch;


public class AppPreferencesFragment extends Fragment {

    private Switch soundSwitch;
    private Switch hideSwitch;
    private Spinner languageSpinner;
    private View mView;
    public AppPreferencesFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_app_preferences, container, false);
        soundSwitch=mView.findViewById(R.id.switch_sound);
        hideSwitch=mView.findViewById(R.id.switch_hide);
        languageSpinner=mView.findViewById(R.id.spinner_language);

        return mView;
    }
}
