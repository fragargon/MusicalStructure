package com.example.android.musicalstructure;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;



/**
 * Created a {@link DialogFragment} alert Dialog which shows
 * a menu for the playlist activity
 */

public class PlaylistDialog extends DialogFragment {

    String toDo;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        toDo = getResources().getString(R.string.to_do);

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyDialogTheme);
        builder.setTitle(R.string.dialog_title)
                .setItems(R.array.dialog_playlist_array, new DialogInterface.OnClickListener() {
                    // The 'which' argument contains the index position of the selected item
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0: // Add a playlist
                                Toast.makeText(getContext(), toDo,
                                        Toast.LENGTH_SHORT).show();
                            case 1: // Random play
                                Toast.makeText(getContext(), toDo,
                                        Toast.LENGTH_SHORT).show();
                            case 2: // Play
                                Intent i = new Intent(getContext(), MainActivity.class);
                            startActivity(i);
                            case 3: // Sort
                                Toast.makeText(getContext(), toDo,
                                        Toast.LENGTH_SHORT).show();
                            case 4: // Search
                            case 5: // Delete
                                Toast.makeText(getContext(), toDo,
                                        Toast.LENGTH_SHORT).show();
                            case 6: // Rename
                                Toast.makeText(getContext(), toDo,
                                        Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        return builder.create();
    }
}
