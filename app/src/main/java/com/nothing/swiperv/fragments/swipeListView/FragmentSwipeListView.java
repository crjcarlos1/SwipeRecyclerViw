package com.nothing.swiperv.fragments.swipeListView;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nothing.swiperv.R;

public class FragmentSwipeListView extends Fragment {
    public static final String TAG = FragmentSwipeListView.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe_list_view, container, false);
        return view;
    }
}
