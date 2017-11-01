package com.hannabennett.jokearama;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by HannaBennett on 11/1/17.
 */

public class ResetViewsFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getActivity())
                .setTitle(R.string.reset_views_dialog_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
