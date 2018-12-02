package com.iessaladillo.alejandro.showdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

public class YesNoDialogFragment extends DialogFragment {

    private static final String ARG_TITLE = "ARG_TITLE";
    private static final String ARG_MESSAGE = "ARG_MESSAGE";
    private static final String ARG_YES = "ARG_YES";
    private static final String ARG_NO = "ARG_NO";
    private String title;
    private String message;
    private String yesText;
    private String noText;
    private Listener listener;

    public interface Listener {
        void onPositiveButtonClick();
        void onNegativeButtonClick();
    }

    public static YesNoDialogFragment newIntance(String title, String message, String yes, String no, Fragment target, int requestCode) {
        YesNoDialogFragment fragment = new YesNoDialogFragment();

        Bundle args = new Bundle();

        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        args.putString(ARG_YES, yes);
        args.putString(ARG_NO, no);
        fragment.setArguments(args);
        fragment.setTargetFragment(target, requestCode);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        obtainArguments();
        // Esto hace que al clicar fuera del dialog no se cierre.
        setCancelable(false);
    }

    private void obtainArguments() {
        Bundle args = getArguments();

        if (args != null) {
            title = args.getString(ARG_TITLE);
            message = args.getString(ARG_MESSAGE);
            yesText = args.getString(ARG_YES);
            noText = args.getString(ARG_NO);
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(requireActivity());

        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setPositiveButton(yesText, (dialog1, which) -> listener.onPositiveButtonClick());
        dialog.setNegativeButton(noText, (dialog12, which) -> listener.onNegativeButtonClick());

        return dialog.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (getTargetFragment() != null) {
                listener = (Listener) getTargetFragment();
            } else {
                listener = (Listener) context;
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("Listener must implement YesNoDialogFragment.Listener");
        }
    }
}
