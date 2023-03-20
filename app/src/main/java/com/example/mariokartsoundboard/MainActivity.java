package com.example.mariokartsoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //creating variables for all components before the on create
    ImageView coconutMall,mapleTreeway,rainbowRoad;
    MediaPlayer mediaPlayer;

    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setting image view variables to corresponding view by id and set on click listener

        coconutMall = findViewById(R.id.coconutMall);
        coconutMall.setOnClickListener(playMusic);

        rainbowRoad = findViewById(R.id.rainbowRoad);
        rainbowRoad.setOnClickListener(playMusic);

        mapleTreeway = findViewById(R.id.mapleTreeway);
        mapleTreeway.setOnClickListener(playMusic);

            //setting on click for next button
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SoundboardPageTwo.class));
                //if media player is running when going to next page release its resources and destory and set to null
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });
    }

    //on click method play music to trigger when image view is clicked
    //it plays the audio file that goes with it
    View.OnClickListener playMusic = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch(view.getId()){
                case R.id.coconutMall:

                    if(mediaPlayer == null){
                        mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.themall);
                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.themall);

                    }
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this,"Playing",Toast.LENGTH_LONG).show();


                    break;
                case R.id.mapleTreeway:
                    if(mediaPlayer == null){
                        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.mappletreeway);
                        Toast.makeText(MainActivity.this,"Playing",Toast.LENGTH_LONG).show();

                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.mappletreeway);

                    }

                    mediaPlayer.start();



                    break;
                case R.id.rainbowRoad:
                    if(mediaPlayer == null){
                        mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.rainbowroad);

                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.rainbowroad);

                    }
                    mediaPlayer.start();
                    Toast.makeText(MainActivity.this,"Playing",Toast.LENGTH_LONG).show();



                    break;
            }


        }



//releasing media player resources
    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }



}