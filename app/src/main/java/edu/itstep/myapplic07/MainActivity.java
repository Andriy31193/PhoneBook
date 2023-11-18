package edu.itstep.myapplic07;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> contacts;
    private ContactAdapter adapter;
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvContacts = findViewById(R.id.lvContacts);
        Button btnAdd = findViewById(R.id.btnAdd);

        ContactApi.init();
        contacts = ContactApi.getContacts();




        adapter = new ContactAdapter(
                this,
                R.layout.item_contact,
                contacts
        );
        lvContacts.setAdapter(adapter);

        lvContacts.setOnItemClickListener(this::showFullInfoContact);
        lvContacts.setOnItemLongClickListener((parent, view, position, id) -> {
            contacts.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
        btnAdd.setOnClickListener(this::startContactDialog);


        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            Contact updatedContact = (Contact) data.getSerializableExtra("contact");
                            int positionToUpdate = contacts.indexOf(ContactApi.findContactById(contacts, updatedContact.getId()));

                            if (positionToUpdate != -1) {
                                contacts.set(positionToUpdate, updatedContact);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                });
    }
    private void startContactDialog(View view) {
        ContactDialog contactDialog = new ContactDialog();
        contactDialog.show(getSupportFragmentManager(), "custom");
    }

    private void showFullInfoContact(AdapterView<?> parent, View view, int position, long id) {
        Contact contact = contacts.get(position);
        Intent intent = new Intent(this, FullInfoActivity.class);
        intent.putExtra("contact", contact);
        launcher.launch(intent);
    }



}
