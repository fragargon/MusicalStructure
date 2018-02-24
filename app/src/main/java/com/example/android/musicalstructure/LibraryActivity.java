package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * {@link LibraryActivity}
 */

public class LibraryActivity extends AppCompatActivity {

    // Initialize global variable
    TextView tvPlaying, tvLibrary, tvPlaylist, tvStreaming;
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Find the views and instantiate Id's
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvStreaming = findViewById(R.id.streaming);
        String artisteName = getResources().getString(R.string.artiste_name);
        String albumName = getResources().getString(R.string.album_name);

        // Create an arrayList of albumItems
        final ArrayList<AlbumItems> albumItems = new ArrayList<>();
        int n = 15;
        for(int i=0; i<n; i++){
            albumItems.add(new AlbumItems(artisteName, albumName, R.drawable.album));
        }

        // Create an {@link ArrayAdapter}, the data source is a list of object
        // whose is from AlbumItems
        GridItemAdapter adapter = new GridItemAdapter(this, albumItems);
        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        // Bind the abstract method to the ListView and gives parameters to its interface
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LibraryActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Set color to the TextView of the current activity
        tvLibrary.setTextColor(getResources().getColor(R.color.blue_light));

        // Set a click listener on the library TextView
        tvPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LibraryActivity.this, MainActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the playlist TextView
        tvPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LibraryActivity.this, PlaylistActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the streaming TextView
        tvStreaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LibraryActivity.this, StreamingActivity.class );
                startActivity(i);
            }
        });
    }
}
