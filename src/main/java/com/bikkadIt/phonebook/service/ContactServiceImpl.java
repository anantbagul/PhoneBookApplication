package com.bikkadIt.phonebook.service;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikkadIt.phonebook.entity.Contact;
import com.bikkadIt.phonebook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSw('Y');
		Contact save=contactRepository.save(contact);
		if(save !=null && save.getContactId() != null) {
		return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> findAll = contactRepository.findAll();
		List<Contact> collect = findAll.stream()
		         .filter(contact -> contact.getActiveSw()=='Y')
		         .collect(Collectors.toList());
	      return collect;
	}

	@Override
	public Contact getContactById(Integer cid) {
		
		Optional<Contact> findById = contactRepository.findById(cid);
		if(findById.isPresent()) {
		Contact contact=	findById.get();
		return contact;
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer cid) {

		/*boolean existsById = contactRepiository.existsById(cid);
		if(existsById) {
		contactRepiository.deleteById(cid);
		return true;
		}
		return false;
	}*/
		
		
		    Optional<Contact> optional = contactRepository.findById(cid);
		    
		      if(optional.isPresent()) {
		    	Contact contact=  optional.get();  
		    	contact.setActiveSw('N');
		    	contactRepository.save(contact);
		    	return true;
		      }
		      return false;
		      }

}
