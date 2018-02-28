package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link ListItemAdapter} is an {@link ArrayAdapter} that can provides
 * the layout for each list based on data source {@link AlbumItems} object.
 */

public class ListItemAdapter extends ArrayAdapter<AlbumItems> {

    // // Initialize global variable
    private Context mContext;

    /**
     * This is a custom constructor.
     * The context is used to inflate the layout file.
     * The list is the data we want to populate into the list
     * @param context The current context. Used to inflate the layout.
     * @param listItem A list of AlbumItems object to display in a list
     */

    public ListItemAdapter(Activity context, ArrayList<AlbumItems> listItem) {
        // Initialize the ArrayAdapter's internal storage for the context
        super(context, 0 , listItem);

        mContext = context;
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView)
     * @param position The position in the list of data that should be displayed.
     * @param convertView The recycled view to populate.
     * @param parent Te parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_album_item, parent, false);
        }

        // Get {@link AlbumItems} object located at this position in the list
        AlbumItems currentAlbum = getItem(position);

        // Find the TextView, get and set the text from the current AlbumItems object
        TextView albumName = listItemView.findViewById(R.id.list_item_playlist_name);
        if (currentAlbum != null) {
            albumName.setText(currentAlbum.getAlbumName());
        }

        // Find the TextView, get and set the text from the current AlbumItems object
        TextView artistName = listItemView.findViewById(R.id.list_item_playlist_description);
        if (currentAlbum != null) {
            artistName.setText(currentAlbum.getArtisteName());
        }

        // Find the ImageView, get and set the image from the current AlbumItems object
        ImageView albumView = listItemView.findViewById(R.id.list_item_icon);
        if (currentAlbum != null) {
            albumView.setImageResource(currentAlbum.getAlbumResourceId());
        }

        // Find the ImageView, get and set the icon from the current AlbumItems object
        ImageView iconView = listItemView.findViewById(R.id.list_item_menu);
        if (currentAlbum != null) {
            iconView.setImageResource(currentAlbum.getIconResourceId());
        }

        // Bind the abstract method to the iconView and gives parameters to its interface
        iconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = (FragmentActivity)(mContext);
                FragmentManager fm = activity.getSupportFragmentManager();
                PlaylistDialog menuDialog = new PlaylistDialog();
                menuDialog.show(fm, "fragment_alert");
            }
        });

        // Bind the abstract method to the albumView and gives parameters to its interface
        albumView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.startActivity(new Intent(mContext, MainActivity.class));
            }
        });

        // Return the whole list item layout
        return listItemView;

    }
}
