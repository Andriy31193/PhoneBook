package edu.itstep.myapplic07;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Random;

public class Contact implements Serializable {

    private int id;
    private final int avatar;
    private String firstName, lastName, phone, email;

    public Contact(int avatar, String firstName, String lastName, String phone, String email) {
        generateId();
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    private void generateId() {
        do {
            this.id = generateRandomId();
        } while (ContactApi.exists(this.id));
    }

    private int generateRandomId() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public int getAvatar() {
        return avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    @NonNull
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", avatar=" + avatar +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
