package com.nothing.swiperv.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nothing.swiperv.R;
import com.nothing.swiperv.fragments.menu.FragmentMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragmentMenu();
    }

    private void showFragmentMenu() {
        getSupportFragmentManager().beginTransaction().addToBackStack(FragmentMenu.TAG);
        getSupportFragmentManager().beginTransaction().add(R.id.conteinerFragments, new FragmentMenu(), FragmentMenu.TAG).commit();
    }
}
