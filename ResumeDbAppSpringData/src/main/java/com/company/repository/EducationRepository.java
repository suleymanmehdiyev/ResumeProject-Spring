package com.company.repository;

import com.company.model.Education;
import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Integer> {
    List<Education> findByUserId(User userId);
}
