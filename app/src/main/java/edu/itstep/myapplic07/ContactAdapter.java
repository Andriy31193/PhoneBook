package edu.itstep.myapplic07;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private final int resource;
    private final List<Contact> contacts;
    private final LayoutInflater inflater;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> contacts) {
        super(context, resource, contacts);
        this.resource = resource;
        this.contacts = contacts;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View container = inflater.inflate(resource, parent, false);

        ImageView ivAvatar = container.findViewById(R.id.ivAvatar);
        TextView tvFirstName = container.findViewById(R.id.tvFirstName);
        TextView tvLastName = container.findViewById(R.id.tvLastName);

        Contact contact = contacts.get(position);
        ivAvatar.setImageResource(contact.getAvatar());
        tvFirstName.setText(contact.getFirstName());
        tvLastName.setText(contact.getLastName());

        return container;
    }
}
