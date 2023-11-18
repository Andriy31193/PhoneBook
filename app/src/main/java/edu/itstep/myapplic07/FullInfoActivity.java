package edu.itstep.myapplic07;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import edu.itstep.myapplic07.databinding.ActivityFullInfoBinding;

public class FullInfoActivity extends AppCompatActivity {
    private ActivityFullInfoBinding binding;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFullInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        contact = (Contact) getIntent().getSerializableExtra("contact");

        binding.ivAvatar.setImageResource(contact.getAvatar());
        binding.etFirstName.setText(contact.getFirstName());
        binding.etLastName.setText(contact.getLastName());
        binding.etPhone.setText(contact.getPhone());
        binding.etAddress.setText(contact.getEmail());

        binding.btnApply.setOnClickListener(view -> {
            contact.setFirstName(binding.etFirstName.getText().toString());
            contact.setLastName(binding.etLastName.getText().toString());
            contact.setPhone(binding.etPhone.getText().toString());
            contact.setEmail(binding.etAddress.getText().toString());

            Intent resultIntent = new Intent();
            resultIntent.putExtra("contact", contact);
            setResult(RESULT_OK, resultIntent);

            finish();
        });
    }
}
