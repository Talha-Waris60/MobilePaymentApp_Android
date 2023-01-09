package com.codewithtalha.atm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;
import java.util.Deque;

public class cardActivity extends AppCompatActivity {

    // Initialize variable
    BottomNavigationView bottomNavigationView;
    Deque<Integer> integerDeque = new ArrayDeque<>(4);
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        // Assign variable
        bottomNavigationView = findViewById(R.id.bottom_nav);

        // Add card fragment in deque list
        integerDeque.push(R.id.nav_card);

        // load card Fragment by default
        loadFragment(new CardFragment());

        // set card fragment as default fragment
        bottomNavigationView.setSelectedItemId(R.id.nav_card);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                // Get selected item id
                int id = item.getItemId();

                // check Condition
                if(integerDeque.contains(id))
                {
                    // when deque lists contains selected id
                    // Check Condition
                    if(id == R.id.nav_card)
                    {
                        // When selected id is equal to home fragment id
                        // check Condition
                        if (integerDeque.size() != 1)
                        {
                            // when deque size is not equal to 1
                            if(flag)
                            {
                                // when flag value is true
                                // Add card fragment in deque list
                                integerDeque.addFirst(R.id.nav_card);

                                // set flag is equal to false
                                flag = false;
                            }
                        }
                    }

                    // Remove selected id from deque list
                    integerDeque.remove(id);
                }

                // push selected id in deque list
                integerDeque.push(id);
                loadFragment(getFragment(item.getItemId()));
                return true;
            }
        });
    }
        private Fragment getFragment(int itemId) {
            switch (itemId)
            {
                case R.id.nav_home:
                    // set checked dashboard fragment
                    bottomNavigationView.getMenu()
                            .getItem(0)
                            .setChecked(true);
                    return new HomeFragment();

                case R.id.nav_card:
                    // set checked dashboard fragment
                    bottomNavigationView.getMenu()
                            .getItem(1)
                            .setChecked(true);
                    return new CardFragment();

                case R.id.nav_history:
                    // set checked dashboard fragment
                    bottomNavigationView.getMenu()
                            .getItem(2)
                            .setChecked(true);
                    return new HistoryFragment();

                case R.id.nav_profile:
                    // set checked dashboard fragment
                    bottomNavigationView.getMenu()
                            .getItem(3)
                            .setChecked(true);
                    return new ProfileFragment();
            }
            // set checked default card fragment
            bottomNavigationView.getMenu().getItem(1).setChecked(true);

            // return card Fragment
            return new CardFragment();
        }




    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
        .beginTransaction()
        .replace(R.id.fragmentContainer,fragment,fragment.getClass().getSimpleName())
        .commit();
    }

    @Override
    public void onBackPressed() {
        // pop to previous fragment
        integerDeque.pop();
        if(!integerDeque.isEmpty())
        {
            // when deque list is not empty
            // load fragment
            loadFragment(getFragment(integerDeque.peek()));
        }
        else
        {
            // when deque is empty
            // finish activity
            finish();
        }
    }
}