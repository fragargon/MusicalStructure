package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    // Initialize global variable
    TextView tvPlaying, tvLibrary, tvPlaylist, tvSearch;
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        // Find the views and instantiate Id's
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvSearch = findViewById(R.id.search);
        String playlistName = getResources().getString(R.string.playlist_name);
        String playlistDescription = getResources().getString(R.string.playlist_description);

        /** Create an {@link ArrayList} from AlbumItems Class (constructor) */
        final ArrayList<AlbumItems> albumItems = new ArrayList<>();
        int n = 50;
        for(int i=0; i<n; i++){
            albumItems.add(new AlbumItems(playlistName, playlistDescription, R.drawable.black_circle_playlist,
                    R.drawable.ic_menu));
        }

        /**
         * Create {@link albumItems} a gridView
         * the data source is a list of object from the ArrayList.
         */
        ListItemAdapter adapter = new ListItemAdapter(this, albumItems);
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // Set color to the TextView of the current activity
        tvPlaylist.setTextColor(getResources().getColor(R.color.blue_light));

        // This listener gets triggered whenever Library TextView is clicked.
        tvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, LibraryActivity.class );
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Playing TextView is clicked.
        tvPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, MainActivity.class );
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Search TextView is clicked.
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PlaylistActivity.this, SearchActivity.class );
                startActivity(i);
            }
        });
    }
}
