package com.bagulIt.phonebook.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bagulIt.phonebook.constants.AppConstants;
import com.bagulIt.phonebook.entity.Contact;
import com.bagulIt.phonebook.props.AppProps;
import com.bagulIt.phonebook.service.ContactService;


@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AppProps appProps;
	
	@GetMapping("/contact")
	private String loadContactForm(Model model) {
		
		Contact contactobj=new Contact();
		model.addAttribute("contact",contactobj);
		return AppConstants.CONTACT_INFO;	
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model) {
        boolean isSaved=	contactService.saveContact(contact);
	      
        Map<String, String> messages = appProps.getMessages();
        
        if(isSaved) {
        	model.addAttribute(AppConstants.SUCCESS, messages.get(AppConstants.SAVE_SUCEESS));
        }else {
        	model.addAttribute(AppConstants.FAIL,messages.get(AppConstants.SAVE_FAIL) );
        }
         return AppConstants.CONTACT_INFO;
	}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
	List<Contact> allContacts=     contactService.getAllContacts();
	model.addAttribute(AppConstants.CONTACTS, allContacts)	;
		
		return AppConstants.CONTACTS;
		
	}
	
}
