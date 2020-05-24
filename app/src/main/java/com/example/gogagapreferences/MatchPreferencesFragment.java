package com.example.gogagapreferences;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import org.florescu.android.rangeseekbar.RangeSeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class MatchPreferencesFragment extends Fragment {

    private ImageView imageView;
    private ImageButton menButton;
    private ImageButton womenButton;
    private static boolean isClickedMen=false;
    private static boolean isClickedWomen=false;

    public MatchPreferencesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView=inflater.inflate(R.layout.fragment_match_preferences, container, false);
        imageView=mView.findViewById(R.id.image_type);
        menButton=mView.findViewById(R.id.img_love_for_man);
        womenButton=mView.findViewById(R.id.img_love_for_women);
//        RangeSeekBar<Integer> mSeekBar = mView.findViewById(R.id.seek_age);
        menButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isClickedMen)
                {
                    menButton.setBackgroundResource(R.drawable.ic_love_for_men);
                    imageView.setImageResource(R.raw.women);
                    isClickedMen=false;
                }else{
                    menButton.setBackgroundResource(R.drawable.ic_love_for_men_selected);
                    if(isClickedWomen)
                    {
                        imageView.setImageResource(R.raw.both);
                    }else{

                        imageView.setImageResource(R.raw.men);
                    }
                    isClickedMen=true;
                }
            }
        });
        womenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isClickedWomen)
                {
                    womenButton.setBackgroundResource(R.drawable.ic_love_for_women);
                    if(isClickedMen)
                        imageView.setImageResource(R.raw.men);
                    else
                        imageView.setImageResource(R.raw.women);
                    isClickedWomen=false;
                }else{
                    womenButton.setBackgroundResource(R.drawable.ic_love_for_women_selected);
                    if(isClickedMen)
                    {
                        imageView.setImageResource(R.raw.both);
                    }else{

                        imageView.setImageResource(R.raw.women);
                    }
                    isClickedWomen=true;
                }
            }
        });
        RangeSeekBar rangeSeekBar = new RangeSeekBar<>(getContext());
        // Set the range
        rangeSeekBar.setRangeValues(18, 70);
        rangeSeekBar.setSelectedMinValue(18);
        rangeSeekBar.setSelectedMaxValue(24);
        rangeSeekBar.setTextAboveThumbsColor(Color.BLUE);
        FrameLayout frameLayout=mView.findViewById(R.id.seekLayout);
        frameLayout.addView(rangeSeekBar);
        rangeSeekBar.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
            @Override
            public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                Log.e("bar",""+minValue+" "+maxValue);
            }
        });


        return mView;
    }
}
