package com.codewithtalha.atm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class cardActivity extends AppCompatActivity {

    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        bnView = findViewById(R.id.bottom_nav);
        loadFrag(new CardFragment(),true);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    loadFrag(new HomeFragment(), false);
                }
                else if(id == R.id.nav_card)
                {
                    loadFrag(new CardFragment(), true);
                }

                else if(id == R.id.nav_history)
                {
                    loadFrag(new HistoryFragment(), false);
                }
                else if(id == R.id.nav_profile)
                {
                    //profile
                    loadFrag(new ProfileFragment(),false);
                }

                return true;
            }
        });

        bnView.setSelectedItemId(R.id.nav_card);

    }

    public void loadFrag(Fragment fragment, boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }

}