package com.company.repository;

import com.company.model.ContactDetail;
import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactDetailRepository extends JpaRepository<ContactDetail,Integer> {
    List<ContactDetail> findByUserId(User userId);
}
