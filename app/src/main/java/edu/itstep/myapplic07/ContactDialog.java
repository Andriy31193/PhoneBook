package edu.itstep.myapplic07;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class ContactDialog extends DialogFragment {
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etPhone;
    private EditText etEmail;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View container = getLayoutInflater().inflate(R.layout.dialog_new_contact, null);
        etFirstName = container.findViewById(R.id.etFirstName);
        etLastName = container.findViewById(R.id.etLastName);
        etPhone = container.findViewById(R.id.etPhone);
        etEmail = container.findViewById(R.id.etEmail);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(container);
        builder.setTitle("New Contact");
        builder.setPositiveButton("save", this::saveContact);
        return builder.create();
    }

    private void saveContact(DialogInterface dialogInterface, int i) {
        Contact contact = new Contact(
                R.drawable.logo,
                etFirstName.getText().toString(),
                etLastName.getText().toString(),
                etPhone.getText().toString(),
                etEmail.getText().toString()
        );
        ContactApi.addContact(contact);
    }
}
