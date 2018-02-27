package com.example.android.musicalstructure;

import android.app.Activity;
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
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView)
     * @param position The position in the list of data that should be displayed.
     * @param convertView The recycled view to populate.
     * @param parent Te parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
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
        albumName.setText(currentAlbum.getAlbumName());

        // Find the TextView, get and set the text from the current AlbumItems object
        TextView artistName = listItemView.findViewById(R.id.list_item_playlist_description);
        artistName.setText(currentAlbum.getArtisteName());

        // Find the ImageView, get and set the image from the current AlbumItems object
        ImageView albumView = listItemView.findViewById(R.id.list_item_icon);
        albumView.setImageResource(currentAlbum.getAlbumResourceId());

        // Find the ImageView, get and set the icon from the current AlbumItems object
        ImageView iconView = listItemView.findViewById(R.id.list_item_menu);
        iconView.setImageResource(currentAlbum.getIconResourceId());

        // Return the whole list item layout
        return listItemView;

    }
}
