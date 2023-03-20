package com.example.mariokartsoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SoundboardPageThree extends AppCompatActivity {
    //!!!!!!!!------ Same as main activity -------------!!!!!!!!
    ImageView mushroomGorge,dkSummit,titleScreen;
    MediaPlayer mediaPlayer;

    Button goBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard_page_three);



        mushroomGorge= findViewById(R.id.mushroomGorge);
        mushroomGorge.setOnClickListener(playMusic);

        dkSummit = findViewById(R.id.dkSummit);
        dkSummit.setOnClickListener(playMusic);

        titleScreen = findViewById(R.id.titleScreen);
        titleScreen.setOnClickListener(playMusic);


        goBackButton= (Button) findViewById(R.id.backButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SoundboardPageThree.this,SoundboardPageTwo.class));
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });
    }

    View.OnClickListener playMusic = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch(view.getId()){
                case R.id.mushroomGorge:

                    if(mediaPlayer == null){
                        mediaPlayer= MediaPlayer.create(SoundboardPageThree.this,R.raw.mushroomgorge);
                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(SoundboardPageThree.this,R.raw.mushroomgorge);

                    }
                    mediaPlayer.start();
                    Toast.makeText(SoundboardPageThree.this,"Playing",Toast.LENGTH_LONG).show();


                    break;
                case R.id.dkSummit:
                    if(mediaPlayer == null){
                        mediaPlayer = MediaPlayer.create(SoundboardPageThree.this,R.raw.dksummit);
                        Toast.makeText(SoundboardPageThree.this,"Playing",Toast.LENGTH_LONG).show();

                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(SoundboardPageThree.this,R.raw.dksummit);

                    }

                    mediaPlayer.start();
                    Toast.makeText(SoundboardPageThree.this,"Playing",Toast.LENGTH_LONG).show();



                    break;
                case R.id.titleScreen:
                    if(mediaPlayer == null){
                        mediaPlayer= MediaPlayer.create(SoundboardPageThree.this,R.raw.titletheme);

                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(SoundboardPageThree.this,R.raw.titletheme);

                    }
                    mediaPlayer.start();
                    Toast.makeText(SoundboardPageThree.this,"Playing",Toast.LENGTH_LONG).show();



                    break;
            }


        }




    };
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }

}