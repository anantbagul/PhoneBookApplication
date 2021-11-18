package com.bagulIt.phonebook.service;

import java.util.List;

import com.bagulIt.phonebook.entity.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);

	List<Contact> getAllContacts( );

	Contact getContactById(Integer cid);

	boolean deleteContactById(Integer cid);

}
