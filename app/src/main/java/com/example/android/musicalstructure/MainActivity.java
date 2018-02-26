package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Initialize global variable
    ImageButton btnLib, btnPl, btnStr;
    TextView tvPlaying, tvLibrary, tvPlaylist, tvStreaming;
    LayoutInflater layoutInflater;
    LinearLayout mLinearLayout;
    HorizontalScrollView mHorizontalScrollView;
    String mAlbumName,  mTrackName;
    ImageView mImageView;
    TextView mAlbumNameView, mTrackNameView;
    ArrayList<Integer> thumbArray;
    ArrayList<String> albumArray, trackArray;

    // Create a method to show the HorizontalScrollView
    private void setUpHorizontalSView() {
        int n = 15;
        int i;

        thumbArray = new ArrayList<>();
        albumArray = new ArrayList<>();
        trackArray = new ArrayList<>();

        for(i=0; i<n; i++){
            thumbArray.add(R.drawable.album);
            albumArray.add(mAlbumName);
            trackArray.add(mTrackName);

            View v = layoutInflater.inflate(R.layout.hscroll_view_item, mHorizontalScrollView, false);
            mImageView = v.findViewById(R.id.horizontal_image_view);
            mAlbumNameView = v.findViewById(R.id.horizontal_album_name);
            mTrackNameView = v.findViewById(R.id.horizontal_track_name);

            mImageView.setImageResource(thumbArray.get(0));
            mAlbumNameView.setText(albumArray.get(0));
            mTrackNameView.setText(trackArray.get(0));

            if (i==(n)-1) {
                mHorizontalScrollView.setBackgroundResource(android.R.color.transparent);
            }
            mLinearLayout.addView(v);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the view LayoutInflater
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        mHorizontalScrollView = findViewById(R.id.horizontal_scroll_view);

        // Find the views and instantiate Id's
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvStreaming = findViewById(R.id.streaming);
        mLinearLayout = findViewById(R.id.track_album_view);
        mAlbumName = getResources().getString(R.string.album_name);
        mTrackName = getResources().getString(R.string.track_name);

        // Method to show the HorizontalScrollView
        setUpHorizontalSView();

        // Set color to the TextView of the current activity
        tvPlaying.setTextColor(getResources().getColor(R.color.blue_light));

        // Set a click listener on the library TextView
        tvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(i);
            }
        });

        // Set a click listener on the playlist TextView
        tvPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(i);
            }
        });

        // Set a click listener on the streaming TextView
        tvStreaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });
    }
}
