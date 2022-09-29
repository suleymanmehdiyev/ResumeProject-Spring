package com.company.service.inter;

import com.company.model.Education;
import com.company.model.User;

import java.util.List;
import java.util.Optional;

public interface EducationServiceInter {
    List<Education> getAllEducationByUserId(User userId);
    Optional<Education> getEducationById(Integer id);
    Education addEducation(Education education);
    Education updateEducation(Education education);
    void deleteEducationById(Integer id);
}
