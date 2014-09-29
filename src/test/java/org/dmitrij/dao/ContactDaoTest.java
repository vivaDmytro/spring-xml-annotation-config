package org.dmitrij.dao;

import org.dmytrij.dao.ContactDao;
import org.dmytrij.entity.Contact;
import org.junit.*;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Дмитрий on 29.09.14.
 */
public class ContactDaoTest {

    private Contact contact;
    private Contact otherContact;
    private ContactDao contactDao;

    @Before
    public void initContact() {

        contact = Mockito.mock(Contact.class);
        otherContact = Mockito.mock(Contact.class);
        contactDao = Mockito.mock(ContactDao.class);
        Mockito.when(contactDao.getAllContacts()).thenReturn(Arrays.asList(contact, otherContact));
    }

    @Test
    public void addContactOnce() {

        contactDao.addContact(contact);
        Mockito.verify(contactDao, Mockito.times(1)).addContact(contact);
    }

    @Test
    public void deleteContact() {

        contactDao.deleteContact(contact);
        Mockito.verify(contactDao, Mockito.times(1)).deleteContact(contact);
    }

    @Test
    public void getAllContacts() {

        List<Contact> contactList = contactDao.getAllContacts();
        Assert.assertNotEquals("list is empty", contactList, Collections.emptyList());
    }
}
