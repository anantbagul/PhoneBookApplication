package com.bikkadIt.phonebook.service;

import java.util.List;

import com.bikkadIt.phonebook.entity.Contact;

public interface ContactService {

	boolean saveContact(Contact contact);

	List<Contact> getAllContacts( );

	Contact getContactById(Integer cid);

	boolean deleteContactById(Integer cid);

}
