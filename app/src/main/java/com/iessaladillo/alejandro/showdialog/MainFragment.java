package com.iessaladillo.alejandro.showdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment implements YesNoDialogFragment.Listener {

    private final String TAG_DIALOG_FRAGMENT = "TAG_DIALOG_FRAGMENT";
    private final int RC_DIALOG_FRAGMENT = 1;
    private final String messagePositiveButton = "yes";
    private final String messageNegativeButton = "no";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setudViews(getView());
    }

    private void setudViews(View view) {
        Button btnShowDialog = ViewCompat.requireViewById(view, R.id.btnShowDialog);


        btnShowDialog.setOnClickListener(v -> openDialog());
    }

    private void openDialog() {
        YesNoDialogFragment.newIntance(getString(R.string.dialog_title), getString(R.string.dialog_message),
                getString(R.string.dialog_possitiveButton),
                getString(R.string.dialog_negativeButton), this, RC_DIALOG_FRAGMENT)
                .show(requireActivity().getSupportFragmentManager(), TAG_DIALOG_FRAGMENT);
    }

    @Override
    public void onPositiveButtonClick() {
        Toast.makeText(requireContext(), messagePositiveButton, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(requireContext(), messageNegativeButton, Toast.LENGTH_SHORT).show();
    }
}
