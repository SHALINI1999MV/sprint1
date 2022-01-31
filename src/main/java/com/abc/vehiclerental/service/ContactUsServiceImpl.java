package com.abc.vehiclerental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.vehiclerental.entity.ContactUsDetails;
import com.abc.vehiclerental.repository.ContactRepository;

@Service 
public class ContactUsServiceImpl implements ContactUsService {
	 
		@Autowired
		private ContactRepository contactRepository;
		
		@Override
		public void addContact(ContactUsDetails contact) {
			contactRepository.save(contact);
		}
		
		@Override
		public void updateContact(ContactUsDetails contact) {
			contactRepository.save(contact);
		}		

		@Override
		public void deleteContact(Long id) {
			// TODO Auto-generated method stub
			contactRepository.deleteById(id);
		}

		@Override
		public List<ContactUsDetails> fetchAllContactDetails() {
			// TODO Auto-generated method stub
			List<ContactUsDetails> contactDetailsList = contactRepository.findAll();
			return contactDetailsList;
			
		}



	}


