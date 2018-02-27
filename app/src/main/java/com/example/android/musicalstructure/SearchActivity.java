package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

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
        tvStreaming = findViewById(R.id.search);

        // Set color to the TextView of the current activity
        tvStreaming.setTextColor(getResources().getColor(R.color.blue_light));

        // This listener gets triggered whenever Library TextView is clicked.
        tvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchActivity.this, LibraryActivity.class );
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Playlist TextView is clicked.
        tvPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchActivity.this, PlaylistActivity.class );
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Playing TextView is clicked.
        tvPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SearchActivity.this, MainActivity.class );
                startActivity(i);
            }
        });
    }
}
