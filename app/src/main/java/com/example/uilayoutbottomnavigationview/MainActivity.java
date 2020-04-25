package com.example.uilayoutbottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.uilayoutbottomnavigationview.fragment.FragmentFavorite;
import com.example.uilayoutbottomnavigationview.fragment.FragmentHome;
import com.example.uilayoutbottomnavigationview.fragment.FragmentSearch;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,new FragmentHome()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.bottom_home:
                            selectedFragment = new FragmentHome();
                            break;
                        case R.id.bottom_person:
                            selectedFragment = new FragmentFavorite();
                            break;
                        case R.id.bottom_search:
                            selectedFragment = new FragmentSearch();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_layout,selectedFragment).commit();
                    return true;
                }
            };
}
