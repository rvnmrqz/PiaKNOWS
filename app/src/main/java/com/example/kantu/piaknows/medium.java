package com.example.kantu.piaknows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class medium extends YouTubeBaseActivity {

   YouTubePlayerView youTubePlayerView;
    Button button;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

    button = (Button) findViewById(R.id.xplayyy);
    youTubePlayerView = (YouTubePlayerView) findViewById(R.id.xeasyyoutube);
    onInitializedListener = new YouTubePlayer.OnInitializedListener() {
        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            youTubePlayer.loadVideo("IxQNYUY0GJE");
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult
        youTubeInitializationResult) {

        }
    };
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            youTubePlayerView.initialize(playerconfig.API_KEY,onInitializedListener);
        }

    });}
}
