package com.abc.vehiclerental.service;
import java.util.List;

import com.abc.vehiclerental.entity.ContactUsDetails;

public interface  ContactUsService {

	public void addContact(ContactUsDetails contact);
	
	public List<ContactUsDetails> fetchAllContactDetails();
	
	public void updateContact(ContactUsDetails contact);
	
	public void deleteContact(Long id);
	
	
}
