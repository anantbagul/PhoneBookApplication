package com.bikkadIt.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bikkadIt.phonebook.entity.Contact;
import com.bikkadIt.phonebook.service.ContactService;

@Controller
public class ViewContactController {

	@Autowired
	private ContactService contactServiceI;

	@GetMapping("/edit")
	public String editContact(@RequestParam("cid") Integer contactId,Model model) {
	Contact contact= contactServiceI.getContactById(contactId);
		model.addAttribute("contact", contact);
		return "contactInfo";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId,Model model) {
	 
		 contactServiceI.deleteContactById(contactId);
		return "redirect:viewContacts";
		
	}
	

}
