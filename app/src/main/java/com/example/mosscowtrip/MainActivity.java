package com.example.mosscowtrip;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private static final int LAYOUT = R.layout.activity_main;
    private ActionBarDrawerToggle mDrawerToggle;
    private ImageButton imageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences pref = getPreferences(MODE_PRIVATE);
        if (pref.getBoolean("isFirstRun", true)){
            pref.edit().putBoolean("isFirstRun", false).apply();

            Intent intent = new Intent(this, Activity_begining.class);
            startActivity(intent);

        }else{
             //   startActivity(intent);
        }

        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(this);

        initNavigationView();
        initToolbar();


        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.test1, R.string.test2);
        mDrawerToggle.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_launcher_foreground));
        drawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_main_menu);

    }

    private void initToolbar(){
          toolbar = findViewById(R.id.toolbar);
          toolbar.setTitle("Городские квесты");
          toolbar.setTitleTextColor(getResources().getColor(R.color.colorWite));
          toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });

          toolbar.inflateMenu(R.menu.menu);
    }

    private void initNavigationView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton:
                Intent intent = new Intent(this, Activity_list.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
