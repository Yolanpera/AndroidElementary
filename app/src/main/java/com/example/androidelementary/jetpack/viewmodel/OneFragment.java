package com.example.androidelementary.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import com.example.androidelementary.R;

import java.security.Provider;

public class OneFragment extends Fragment {

    private ShareDataViewModel shareDataViewModel;
    private SeekBar seekBar;

    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View parentView =  inflater.inflate(R.layout.fragment_one, container, false);
        seekBar = parentView.findViewById(R.id.seek_Bar);
        shareDataViewModel = new ViewModelProvider(requireActivity()).get(ShareDataViewModel.class);
        MutableLiveData<Integer> liveData = shareDataViewModel.getProgress();
        liveData.observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(Integer progress) {
                seekBar.setProgress(progress);
            }
        });
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
    }

}