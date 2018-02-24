package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xav on 18/02/18.
 */

public class StreamingActivity extends AppCompatActivity {

    // Initialize global variable
    TextView tvPlaying, tvLibrary, tvPlaylist, tvStreaming;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming);

        // Find the views and instantiate Id's
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvStreaming = findViewById(R.id.streaming);

        // Set color to the TextView of the current activity
        tvStreaming.setTextColor(getResources().getColor(R.color.blue_light));

        // Set a click listener on the library TextView
        tvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StreamingActivity.this, LibraryActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the playlist TextView
        tvPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StreamingActivity.this, PlaylistActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the streaming TextView
        tvPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StreamingActivity.this, MainActivity.class );
                startActivity(i);
            }
        });
    }
}
