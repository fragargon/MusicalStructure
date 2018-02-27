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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Initialize global variable
    ImageButton iBtn_previous, iBtn_play, iBtn_next, iBtn_playlistAdd;
    TextView tvPlaying, tvLibrary, tvPlaylist, tvStreaming;
    LayoutInflater layoutInflater;
    LinearLayout mLinearLayout;
    HorizontalScrollView mHorizontalScrollView;
    String mAlbumName,  mTrackName, mPrevious, mPlay, mNext;
    ImageView mImageView;
    TextView mAlbumNameView, mTrackNameView;
    ArrayList<Integer> thumbArray;
    ArrayList<String> albumArray, trackArray;

    /**
     *  Create a method to display album track in a horizontalScrollView.
     *  it contains the ImageView album, TextView album's name and track's name.
     *  It is populated through ArrayList and inflate in View hscroll_view_item.
     */
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
            mTrackNameView.setText((i+1) + ". " + trackArray.get(0));

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

        // Find the views and instantiate Id's Layout
        layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        mHorizontalScrollView = findViewById(R.id.horizontal_scroll_view);

        // Find the views and instantiate Id's
        iBtn_playlistAdd = findViewById(R.id.add_playlist);
        iBtn_previous = findViewById(R.id.skip_previous_button);
        iBtn_play = findViewById(R.id.play_button);
        iBtn_next = findViewById(R.id.skip_next_button);
        tvPlaying = findViewById(R.id.playing);
        tvLibrary = findViewById(R.id.library);
        tvPlaylist = findViewById(R.id.playlist);
        tvStreaming = findViewById(R.id.search);
        mLinearLayout = findViewById(R.id.track_album_view);
        mAlbumName = getResources().getString(R.string.album_name);
        mTrackName = getResources().getString(R.string.track_name);
        mPrevious = getResources().getString(R.string.skip_previous);
        mPlay = getResources().getString(R.string.play);
        mNext = getResources().getString(R.string.skip_next);

        // Method to show the HorizontalScrollView
        setUpHorizontalSView();

        // Set color to the TextView of the current activity
        tvPlaying.setTextColor(getResources().getColor(R.color.blue_light));

        // This listener gets triggered whenever Library TextView is clicked.
        tvLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Playlist TextView is clicked.
        tvPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(i);
            }
        });

        // This listener gets triggered whenever Search TextView is clicked.
        tvStreaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });

        // This listener gets triggered whenever the skip previous ImageButton is clicked.
        iBtn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mPrevious,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // This listener gets triggered whenever the play ImageButton is clicked.
        iBtn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mPlay,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // This listener gets triggered whenever the next ImageButton is clicked.
        iBtn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mNext,
                        Toast.LENGTH_SHORT).show();
            }
        });

        // This listener gets triggered whenever addPlaylist ImageButton is clicked.
        iBtn_playlistAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LibraryActivity.class);
                startActivity(i);
            }
        });

    }
}
