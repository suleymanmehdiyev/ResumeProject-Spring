package com.company.service.inter;

import com.company.model.Skill;

import java.util.List;
import java.util.Optional;

public interface SkillServiceInter {
    List<Skill> getAll();
    Optional<Skill> getById(int id);
    Skill addSkill(Skill u);
    Skill updateSkill(Skill u);
    void deleteSkill(int id);
    Skill getByName(String name);
}
