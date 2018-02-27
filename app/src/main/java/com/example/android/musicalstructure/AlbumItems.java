package com.example.android.musicalstructure;

/**
 * Creating a custom class called AlbumItems.
 * Object of this call will have 3 properties:
 * (albumName, artisteName and albumResourceId)
 * {@link AlbumItems} represents a data model class
 * It contains the representation for the gridView and listView
 * use in MusicalStructure APK
 *
 */

public class AlbumItems {

    /** Name of the album */
    private String mAlbumName;

    /** Name of the artist */
    private String mArtisteName;

    /** Drawable for the album */
    private int mAlbumResourceId;

    /** Menu icon for the view */
    private int mIconResourceId = NO_ICON_PROVIDED;

    /** Constant value that represents no icon provided */
    private static int  NO_ICON_PROVIDED = -1;

    /**
     * Create a new grid item object (constructor)
     * @param albumName is the name of the album
     * @param artisteName is the name of the artist
     * @param albumResourceId is the drawable ID for the album
     */
    public AlbumItems(String albumName, String artisteName, int albumResourceId) {
        mAlbumName = albumName;
        mArtisteName = artisteName;
        mAlbumResourceId = albumResourceId;
    }

    /**
     * Create a new list item object (constructor)
     * @param albumName is the name of the album
     * @param artisteName is the name of the artist
     * @param albumResourceId is the drawable ID for the album
     */
    public AlbumItems(String albumName, String artisteName, int albumResourceId, int iconResourceId) {
        mAlbumName = albumName;
        mArtisteName = artisteName;
        mAlbumResourceId = albumResourceId;
        mIconResourceId = iconResourceId;
    }

    /** Get the name of the album (method) */
    public String getAlbumName () {
        return mAlbumName;
    }

    /** Get the name of the artist (method) */
    public String getArtisteName () {
        return mArtisteName;
    }

    /** Get the image resource ID of the album (method) */
    public int getAlbumResourceId() {
        return mAlbumResourceId;
    }

    /** Get the icon resource ID for the menu (method) */
    public int getIconResourceId() {
        return mIconResourceId;
    }

    /** Return the string representation of the (@link AlbumItems) object*/
    @Override
    public String toString() {
        return "AlbumItems{" +
                "mAlbumName='" + mAlbumName + '\'' +
                ", mArtisteName='" + mArtisteName + '\'' +
                ", mAlbumResourceId=" + mAlbumResourceId + '}';
    }

}
