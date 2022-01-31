package com.abc.vehiclerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.vehiclerental.entity.ContactUsDetails;
import com.abc.vehiclerental.service.ContactUsService;

@RestController
@RequestMapping("/contactdetails")
public class ContactController {

	@Autowired
	private ContactUsService contactUsService;

	@PostMapping("/admin/save")
	public ResponseEntity<String> saveContact(@RequestBody ContactUsDetails contact) {
		contactUsService.addContact(contact);
		return new ResponseEntity<>("saved Contact Details: " + contact.getId(), HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<ContactUsDetails>> getAllContact() {
		List<ContactUsDetails> contactDetailList = contactUsService.fetchAllContactDetails();
		return new ResponseEntity<>(contactDetailList, HttpStatus.OK);
	}

	@PutMapping("/admin/update")
	public ResponseEntity<String> updatingContact(@RequestBody ContactUsDetails contact) {
		contactUsService.updateContact(contact);
		return new ResponseEntity<>("Contact Details Updated successfully. ", HttpStatus.CREATED);
	}

	@DeleteMapping("/admin/delete/{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") long id) {
		contactUsService.deleteContact(id);
		return new ResponseEntity<>("Contact Detail deleted Successfully", HttpStatus.OK);
	}

}
