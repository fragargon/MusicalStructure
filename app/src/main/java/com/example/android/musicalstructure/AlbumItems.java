package com.example.android.musicalstructure;

/**
 * Creating a custom class called AlbumItems.
 * Object of this call will have 3 properties:
 * (albumName, artisteName and albumResourceId)
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

    /**
     * Create a new grid item object
     * @param albumName is the name of the album
     * @param artisteName is the name of the artist
     * @param albumResourceId is the drawable ID for the album
     */
    public AlbumItems(String albumName, String artisteName, int albumResourceId) {
        mAlbumName = albumName;
        mArtisteName = artisteName;
        mAlbumResourceId = albumResourceId;
    }

    /** Get the name of the album */
    public String getAlbumName () {
        return mAlbumName;
    }

    /** Get the name of the artist */
    public String getArtisteName () {
        return mArtisteName;
    }

    /** Get the image resource ID of the album*/
    public int getAlbumResourceId() {
        return mAlbumResourceId;
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
