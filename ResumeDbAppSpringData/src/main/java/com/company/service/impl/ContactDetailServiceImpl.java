package com.company.service.impl;

import com.company.model.ContactDetail;
import com.company.model.Education;
import com.company.model.User;
import com.company.repository.ContactDetailRepository;
import com.company.service.inter.ContactDetailServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailServiceImpl implements ContactDetailServiceInter {

    private ContactDetailRepository contactDetailRepository;

    @Autowired
    public ContactDetailServiceImpl(ContactDetailRepository contactDetailRepository) {
        this.contactDetailRepository = contactDetailRepository;
    }

    @Override
    public List<ContactDetail> getAllContactDetail() {
        List<ContactDetail> cd = contactDetailRepository.findAll();
        return cd;
    }

    @Override
    public List<ContactDetail> getContactDetailById(User userId) {
        List<ContactDetail> cd = contactDetailRepository.findByUserId(userId);
        return cd;
    }

    @Override
    public ContactDetail addContactDetail(ContactDetail contactDetail) {
        contactDetailRepository.save(contactDetail);
        return contactDetail;
    }

    @Override
    public ContactDetail updateContactDetail(ContactDetail contactDetail) {
        Optional<ContactDetail> findContactDetail = contactDetailRepository.findById(contactDetail.getId());
        ContactDetail updateContactDetail = null;
        if(findContactDetail.isPresent()) {
            updateContactDetail = findContactDetail.get();

            updateContactDetail.setPhoneNumber(contactDetail.getPhoneNumber());
            updateContactDetail.setRegAddress(contactDetail.getRegAddress());
            updateContactDetail.setActualAddress(contactDetail.getActualAddress());

            contactDetailRepository.save(contactDetail);
        }
        return contactDetail;
    }

    @Override
    public void deleteContactDetailById(Integer id) {
       contactDetailRepository.deleteById(id);
    }
}
