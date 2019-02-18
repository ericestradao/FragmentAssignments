package com.example.user.openalertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Toast;

public class MyAlertDialogWindow extends DialogFragment {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity().getBaseContext(), "Application is quitting ...", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
            };

            DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity().getBaseContext(), "Returning to the main activity", Toast.LENGTH_SHORT).show();

                }
            };

            AlertDialog.Builder b = new AlertDialog.Builder(getActivity());

            b.setMessage("Do you want to quit this application ?");
            b.setNegativeButton("No", (DialogInterface.OnClickListener) negativeClick);
            b.setPositiveButton("Yes", (DialogInterface.OnClickListener) positiveClick);
            b.setTitle("Confirmation");
            Dialog d = b.create();

            return d;
        }

    }

