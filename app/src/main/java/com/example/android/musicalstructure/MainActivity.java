package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Initialize global variable
    ImageButton btnLib, btnPl, btnStr;
    TextView tvPlaying, tvLibrary, tvPlaylist, tvStreaming;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the views and instantiate Id's
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvStreaming = findViewById(R.id.streaming);

        // Set color to the TextView of the current activity
        tvPlaying.setTextColor(getResources().getColor(R.color.blue_light));

        // Set a click listener on the library TextView
        tvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LibraryActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the playlist TextView
        tvPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlaylistActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the streaming TextView
        tvStreaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, StreamingActivity.class );
                startActivity(i);
            }
        });
    }
}
