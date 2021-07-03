package com.example.mosscowtrip;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Activity_qest_bylgakov extends AppCompatActivity {

    MediaPlayer mySong;
    private boolean flagPlay = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qwest_bylgakov);

        Fragment frag1 = new Bulgakov_quests_fragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_bulgakov, frag1);
        ft.commit();
        //mySong = MediaPlayer.create(Activity_qest_bylgakov.this, R.raw.music_test);
    }

    public void playIT(View v){
        if (!flagPlay) {
            flagPlay = true;
            mySong.start();
        }else{
            flagPlay = false;
            mySong.pause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mySong.stop();
    }
}
