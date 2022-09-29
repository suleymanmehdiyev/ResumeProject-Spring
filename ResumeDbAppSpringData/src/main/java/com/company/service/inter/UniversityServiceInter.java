package com.company.service.inter;

import com.company.model.University;

import java.util.List;
import java.util.Optional;

public interface UniversityServiceInter {
    List<University> getAll();
    Optional<University> getById(int id);
    University addUniversity(University university);
    University updateUniversity(University university);
    void deleteUniversity(int id);
}
