package com.example.android.musicalstructure;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;


/**
 * Created a {@link DialogFragment} alert Dialog which shows
 * a simple menu for the playlist activity
 */

public class PlaylistDialog extends DialogFragment {

    // Declare global variable
    String toDo;
    String [] plArray;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // initialize the variables.
        Resources res = getResources();
        plArray = res.getStringArray(R.array.dialog_playlist_array);
        toDo = getResources().getString(R.string.to_do);

        // Build the dialog. Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);
        // Set the title for dialog
        builder.setTitle(R.string.dialog_title)
                // Set the items for the list. We use an array.
                // Set an listener on each item
                .setItems(plArray, new DialogInterface.OnClickListener() {
                    // send the selected index to the activity
                    public void onClick(DialogInterface dialog, int i) {
                        switch (i) {
                            case 0: // Add a playlist
                                Intent iL = new Intent(getContext(), LibraryActivity.class);
                                startActivity(iL);
                                break;
                            case 1: // Random play
                                Intent iR = new Intent(getContext(), MainActivity.class);
                                startActivity(iR);
                                break;
                            case 2: // Queuing
                                Toast.makeText(getContext(), toDo + "\n" + plArray[i],
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 3: // Play
                                Intent iM = new Intent(getContext(), MainActivity.class);
                                startActivity(iM);
                                break;
                            case 4: // Sort
                                Toast.makeText(getContext(), toDo + "\n" + plArray[i],
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 5: // Search
                                Toast.makeText(getContext(), toDo + "\n" + plArray[i],
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 6: // Delete
                                Toast.makeText(getContext(), toDo + "\n" + plArray[i],
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 7: // Rename
                                Toast.makeText(getContext(), toDo + "\n" + plArray[i],
                                        Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                });
        return builder.create();
    }
}
