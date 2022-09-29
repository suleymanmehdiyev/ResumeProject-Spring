package com.company.service.impl;

import com.company.model.Education;
import com.company.model.Skill;
import com.company.model.University;
import com.company.model.User;
import com.company.repository.EducationRepository;
import com.company.service.inter.EducationServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class EducationServiceImpl implements EducationServiceInter {

    private EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public List<Education> getAllEducationByUserId(User userId) {
        List<Education> edu = educationRepository.findByUserId(userId);
        return edu;
    }

    @Override
    public Optional<Education> getEducationById(Integer id) {
        Optional<Education> edu = educationRepository.findById(id);
        return edu;
    }

    @Override
    public Education addEducation(Education education) {
        educationRepository.save(education);
        return education;
    }

    @Override
    public Education updateEducation(Education education) {
        Optional<Education> findEducation = educationRepository.findById(education.getId());
        Education updateEducation = null;
        if(findEducation.isPresent()) {
            updateEducation = findEducation.get();

            updateEducation.setDegree(education.getDegree());
            updateEducation.setSpeciality(education.getSpeciality());
            updateEducation.setUniversityId(education.getUniversityId());
            updateEducation.setBeginDate(education.getBeginDate());
            updateEducation.setEndDate(education.getEndDate());

            educationRepository.save(updateEducation);
        }
        return updateEducation;
    }


    @Override
    public void deleteEducationById(Integer id) {
        educationRepository.deleteById(id);
    }
}
