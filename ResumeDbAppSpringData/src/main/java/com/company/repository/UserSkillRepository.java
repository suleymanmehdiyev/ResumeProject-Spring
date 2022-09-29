package com.company.repository;

import com.company.model.User;
import com.company.model.UserSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill,Integer> {
    List<UserSkill> findByUser(User userId);
}
