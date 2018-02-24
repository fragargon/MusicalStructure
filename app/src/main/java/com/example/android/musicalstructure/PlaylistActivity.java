package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by xav on 18/02/18.
 */

public class PlaylistActivity extends AppCompatActivity {

    // Initialize global variable
    TextView tvPlaying, tvLibrary, tvPlaylist, tvStreaming;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        // Find the views and instantiate Id's
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvStreaming = findViewById(R.id.streaming);
        String playlistName = getResources().getString(R.string.playlist_name);
        String playlistDescription = getResources().getString(R.string.playlist_description);

        // Create an arrayList of albumItems
        final ArrayList<AlbumItems> albumItems = new ArrayList<>();
        int n = 15;
        for(int i=0; i<n; i++){
            albumItems.add(new AlbumItems(playlistName, playlistDescription, R.drawable.black_circle_playlist));
        }

        // Create an {@link ArrayAdapter}, the data source is a list of object
        // whose is from AlbumItems
        ListItemAdapter adapter = new ListItemAdapter(this, albumItems);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        // Bind the abstract method to the ListView and gives parameters to its interface
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PlaylistActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Set color to the TextView of the current activity
        tvPlaylist.setTextColor(getResources().getColor(R.color.blue_light));

        // Set a click listener on the library TextView
        tvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, LibraryActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the playlist TextView
        tvPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, MainActivity.class );
                startActivity(i);
            }
        });

        // Set a click listener on the streaming TextView
        tvStreaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, StreamingActivity.class );
                startActivity(i);
            }
        });
    }
}
