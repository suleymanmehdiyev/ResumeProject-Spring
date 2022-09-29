package com.company.service.impl;

import com.company.model.University;
import com.company.model.UserSkill;
import com.company.repository.UniversityRepository;
import com.company.service.inter.UniversityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityServiceInter {
//    @PersistenceContext
//    EntityManager em;
    private UniversityRepository universityRepository;

    @Autowired
    public UniversityServiceImpl(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    @Override
    public List<University> getAll() {
//        Query query = em.createQuery("select uni from University uni");
        List<University> universities = universityRepository.findAll();
        return universities;
    }

    @Override
    public Optional<University> getById(int id) {
        Optional<University> uni = universityRepository.findById(id);
        return uni;
    }

    @Override
    public University addUniversity(University uni) {
        universityRepository.save(uni);
        return uni;
    }

    @Override
//    @Transactional
    public University updateUniversity(University uni) {
        Optional<University> findUniversity = universityRepository.findById(uni.getId());
        University updateUniversity = null;
        if(findUniversity.isPresent()) {
            updateUniversity = findUniversity.get();
            updateUniversity.setUniName(uni.getUniName());
            universityRepository.save(updateUniversity);
        }
        return updateUniversity;
    }

    @Override
    public void deleteUniversity(int id) {
        universityRepository.deleteById(id);
    }
}
