package com.bikkadIt.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bikkadIt.phonebook.entity.Contact;
import com.bikkadIt.phonebook.service.ContactService;


@Controller
public class ContactInfoController {

	@Autowired
	private ContactService contactservice;
	
	@GetMapping("/contact")
	private String loadContactForm(Model model) {
		Contact contactobj=new Contact();
		model.addAttribute("contact",contactobj);
		return "contactInfo";	
	}
	
	@PostMapping("/saveContact")
	public String saveContact(Contact contact,Model model) {
        boolean isSaved=	contactservice.saveContact(contact);
	   if(isSaved) {
        	model.addAttribute("success", "contact saved Successfully");
        }else {
        	model.addAttribute("error", "Failed to save Contact");
        }
         return "contactInfo" ;
	}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
	List<Contact> allContacts=     contactservice.getAllContacts();
	model.addAttribute("contacts", allContacts)	;
		
		return "contacts";
		
	}
	
}
