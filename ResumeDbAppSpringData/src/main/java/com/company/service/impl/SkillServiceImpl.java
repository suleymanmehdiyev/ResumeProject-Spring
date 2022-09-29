package com.company.service.impl;

import com.company.model.Skill;
import com.company.model.University;
import com.company.repository.SkillRepository;
import com.company.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class SkillServiceImpl implements SkillServiceInter {
//    @PersistenceContext
//    EntityManager em;

    private SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skills = skillRepository.findAll();
        return skills;
    }

    @Override
    public Optional<Skill> getById(int id) {
        Optional<Skill> s = skillRepository.findById(id);
        return s;
    }

    @Override
    @Transactional
    public Skill addSkill(Skill skill) {
        skillRepository.save(skill);
        return skill;
    }

    @Override
//    @Transactional
    public Skill updateSkill(Skill skill) {
        Optional<Skill> findSkill = skillRepository.findById(skill.getId());
        Skill updateSkill = null;
        if(findSkill.isPresent()) {
            updateSkill = findSkill.get();
            updateSkill.setSkillName(skill.getSkillName());
            skillRepository.save(updateSkill);
        }
        return updateSkill;
    }

    @Override
    public void deleteSkill(int id) {
        skillRepository.deleteById(id);
    }

    @Override
    public Skill getByName(String name) {
       Skill skillName = skillRepository.findBySkillName(name);
       return skillName;
    }
}
