package com.company.service.impl;

import com.company.model.User;
import com.company.model.UserSkill;
import com.company.repository.UserSkillRepository;
import com.company.service.inter.UserSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class UserSkillServiceImpl implements UserSkillServiceInter {
//    @PersistenceContext
//    EntityManager em;

//   private UserSkillDAOInter userSkillDAO;
   private UserSkillRepository userSkillRepository;

    @Autowired
    public UserSkillServiceImpl(UserSkillRepository userSkillRepository) {
//        this.userSkillDAO = userSkillDAO;
        this.userSkillRepository = userSkillRepository;
    }

    @Override
    public List<UserSkill> getAllUserSkill(User userId) {
        List<UserSkill> userSkills = userSkillRepository.findByUser(userId);
        return userSkills;
    }

    @Override
    public Optional<UserSkill> getById(Integer id) {
       return userSkillRepository.findById(id);
    }

    @Override
    public UserSkill addUserSkill(UserSkill userSkill) {
        return userSkillRepository.save(userSkill);
    }

    @Override
    public UserSkill updateUserSkill(UserSkill userSkill) {
        Optional<UserSkill> findUserSkill = userSkillRepository.findById(userSkill.getId());
        UserSkill updateUserSkill = null;
        if(findUserSkill.isPresent()) {
            updateUserSkill = findUserSkill.get();
            updateUserSkill.setSkill(userSkill.getSkill());
            userSkillRepository.save(updateUserSkill);
        }
        return updateUserSkill;
    }

    @Override
    public void deleteUserSkillById(Integer id) {
        userSkillRepository.deleteById(id);
    }
}
