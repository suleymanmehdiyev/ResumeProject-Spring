package com.company.service.inter;

import com.company.model.User;
import com.company.model.UserSkill;

import java.util.List;
import java.util.Optional;

public interface UserSkillServiceInter {
    List<UserSkill> getAllUserSkill(User userId);
    Optional<UserSkill> getById(Integer id);
    UserSkill addUserSkill(UserSkill userSkill);
    UserSkill updateUserSkill(UserSkill userSkill);
    void deleteUserSkillById(Integer id);
}
