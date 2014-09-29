package org.dmytrij.dao;

import org.dmytrij.entity.Contact;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by Дмитрий on 18.09.14.
 */
public class ContactDaoImpl implements ContactDao {

    private List<Contact> contacts;
    @Value("${maxContactsCount}")
    private Integer maxContactsCount;

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public void addContact(Contact contact) {

        contacts.add(contact);
    }

    @Override
    public void deleteContact(Contact contact) {

        contacts.remove(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contacts;
    }

    @Override
    public void clearAll() {
        contacts.clear();
    }

    @PostConstruct
    private void postConstruct(){
        if(contacts.size() >= maxContactsCount) {
            contacts.remove(0);
            contacts.remove(1);
        }
    }
}
