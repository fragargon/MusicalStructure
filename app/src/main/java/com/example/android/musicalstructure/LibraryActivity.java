package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class LibraryActivity extends AppCompatActivity {

    // Initialize global variable
    TextView tvPlaying, tvLibrary, tvPlaylist, tvSearch;
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Find the views and instantiate Id's
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvSearch = findViewById(R.id.search);
        String artisteName = getResources().getString(R.string.artiste_name);
        String albumName = getResources().getString(R.string.album_name);

        /** Create an {@link ArrayList} from AlbumItems Class (constructor) */
        final ArrayList<AlbumItems> albumItems = new ArrayList<>();
        int n = 50;
        for(int i=0; i<n; i++){
            albumItems.add(new AlbumItems(artisteName, albumName, R.drawable.album));
        }

        /**
         * Create {@link albumItems} a gridView
         * the data source is a list of object from the ArrayList.
         */
        GridItemAdapter adapter = new GridItemAdapter(this, albumItems);
        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(adapter);
        // Bind the abstract method to the ListView and gives parameters to its interface
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(LibraryActivity.this, MainActivity.class );
                startActivity(i);

            }
        });

        // Set color to the TextView of the current activity
        tvLibrary.setTextColor(getResources().getColor(R.color.blue_light));

        // This listener gets triggered whenever Playing TextView is clicked.
        tvPlaying.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LibraryActivity.this, MainActivity.class );
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Playlist TextView is clicked.
        tvPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LibraryActivity.this, PlaylistActivity.class );
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Search TextView is clicked.
        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LibraryActivity.this, SearchActivity.class );
                startActivity(i);
            }
        });
    }
}
