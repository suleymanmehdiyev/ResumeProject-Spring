package com.company.service.inter;

import com.company.model.ContactDetail;
import com.company.model.User;

import java.util.List;

public interface ContactDetailServiceInter {
    List<ContactDetail> getAllContactDetail();
    List<ContactDetail> getContactDetailById(User userId);
    ContactDetail addContactDetail(ContactDetail contactDetail);
    ContactDetail updateContactDetail(ContactDetail contactDetail);
    void deleteContactDetailById(Integer id);
}
