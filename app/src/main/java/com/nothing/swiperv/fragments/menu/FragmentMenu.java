package com.nothing.swiperv.fragments.menu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.nothing.swiperv.R;
import com.nothing.swiperv.fragments.swipe.view.FragmentSwipe;

public class FragmentMenu extends Fragment implements View.OnClickListener {
    public static final String TAG = FragmentMenu.class.getSimpleName();

    private Button btnSwipe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        btnSwipe = view.findViewById(R.id.btnSwipe);
        btnSwipe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSwipe:
                showFragmentSwipe();
                break;
        }
    }

    private void showFragmentSwipe() {
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.addToBackStack(FragmentSwipe.TAG);
        transaction.replace(R.id.conteinerFragments, new FragmentSwipe(), FragmentSwipe.TAG).commit();
    }

}
