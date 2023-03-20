package com.example.mariokartsoundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SoundboardPageTwo extends AppCompatActivity {
    //!!!!!!!!------ Same as main activity -------------!!!!!!!!
    ImageView moomooMeadows,grumbleVolacano,warioGoldMine;
    MediaPlayer mediaPlayer;

    Button goBackButton,nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard_page_two);


        moomooMeadows = findViewById(R.id.mooMooMeadows);
        moomooMeadows.setOnClickListener(playMusic);

        grumbleVolacano = findViewById(R.id.grumbleVolcano);
        grumbleVolacano.setOnClickListener(playMusic);

        warioGoldMine = findViewById(R.id.warioGoldMine);
        warioGoldMine.setOnClickListener(playMusic);


        goBackButton= (Button) findViewById(R.id.backButton);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SoundboardPageTwo.this,MainActivity.class));
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });


        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SoundboardPageTwo.this,SoundboardPageThree.class));
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
                case R.id.mooMooMeadows:

                    if(mediaPlayer == null){
                        mediaPlayer= MediaPlayer.create(SoundboardPageTwo.this,R.raw.moomoo);
                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(SoundboardPageTwo.this,R.raw.moomoo);

                    }
                    mediaPlayer.start();
                    Toast.makeText(SoundboardPageTwo.this,"Playing",Toast.LENGTH_LONG).show();


                    break;
                case R.id.grumbleVolcano:
                    if(mediaPlayer == null){
                        mediaPlayer = MediaPlayer.create(SoundboardPageTwo.this,R.raw.volcano);
                        Toast.makeText(SoundboardPageTwo.this,"Playing",Toast.LENGTH_LONG).show();

                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(SoundboardPageTwo.this,R.raw.volcano);

                    }

                    mediaPlayer.start();
                    Toast.makeText(SoundboardPageTwo.this,"Playing",Toast.LENGTH_LONG).show();



                    break;
                case R.id.warioGoldMine:
                    if(mediaPlayer == null){
                        mediaPlayer= MediaPlayer.create(SoundboardPageTwo.this,R.raw.goldmine);

                    }
                    else if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer= MediaPlayer.create(SoundboardPageTwo.this,R.raw.goldmine);

                    }
                    mediaPlayer.start();
                    Toast.makeText(SoundboardPageTwo.this,"Playing",Toast.LENGTH_LONG).show();



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