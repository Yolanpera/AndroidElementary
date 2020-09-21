package com.example.androidelementary.jetpack.viewmodel;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.androidelementary.R;

public class TwoFragment extends Fragment {

    private ShareDataViewModel shareDataViewModel;
    private SeekBar seekBar;

    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parentView =  inflater.inflate(R.layout.fragment_two, container, false);
        seekBar = parentView.findViewById(R.id.seek_Bar);
        shareDataViewModel = new ViewModelProvider(requireActivity()).get(ShareDataViewModel.class);
        MutableLiveData<Integer> liveData = (MutableLiveData<Integer>)shareDataViewModel.getProgress();
        liveData.observe(getViewLifecycleOwner(), progress -> seekBar.setProgress(progress));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                liveData.setValue(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        return parentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shareDataViewModel = new ViewModelProvider(this).get(ShareDataViewModel.class);
    }
}