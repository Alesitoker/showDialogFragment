package com.iessaladillo.alejandro.showdialog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentByTag(MainFragment.class.getSimpleName()) == null) {
            loadInitialFragment();
        }
        initViews();

    }

    private void initViews() {

    }

    private void loadInitialFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new MainFragment(),
                MainFragment.class.getSimpleName()).commit();
    }
}
