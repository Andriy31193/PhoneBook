package edu.itstep.myapplic07;

import java.util.ArrayList;
import java.util.List;

public class ContactApi {
    private static final List<Contact> contacts = new ArrayList<>();
    public static void init(){
        contacts.add(new Contact(R.drawable.logo, "Ivan", "Ivanov", "666", "ivan@gmail.com"));
        contacts.add(new Contact(R.drawable.logo, "Petr", "Petrov", "777", "petr@gmail.com"));
        contacts.add(new Contact(R.drawable.logo, "Stepan", "Stepanov", "888", "stepan@gmail.com"));

    }

    public static List<Contact> getContacts() {
        return contacts;
    }

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }
    public static Contact findContactById(List<Contact> contacts, int targetId) {
        for (Contact contact : contacts) {
            if (contact.getId() == targetId) {
                return contact;
            }
        }
        return null;
    }
    public static boolean exists(int id)
    {
        return findContactById(contacts, id) != null;
    }
}
