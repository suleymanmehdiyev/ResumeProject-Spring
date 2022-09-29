package com.company.service.impl;

import com.company.config.Config;
import com.company.model.EmploymentHistory;
import com.company.model.Skill;
import com.company.model.User;
import com.company.repository.EmploymentHistoryRepository;
import com.company.service.inter.EmploymentHistoryServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class EmploymentHistoryServiceImpl implements EmploymentHistoryServiceInter {

    @Autowired
    private EmploymentHistoryRepository empHistoryRepository;

    @Override
    public List<EmploymentHistory> getAllEmploymentHistory(User userId) {

        List<EmploymentHistory> empHistory = empHistoryRepository.findByUserId(userId);
        return empHistory;
    }

    @Override
    public Optional<EmploymentHistory> getEmploymentHistoryById(Integer id) {
        Optional<EmploymentHistory> empHistory = empHistoryRepository.findById(id);
        return empHistory;
    }

    @Override
    public EmploymentHistory addEmploymentHistory(EmploymentHistory empHistory) {
        empHistoryRepository.save(empHistory);
        return empHistory;
    }

    @Override
    public EmploymentHistory updateEmploymentHistory(EmploymentHistory empHistory) {
        Optional<EmploymentHistory> findEmpHistory = empHistoryRepository.findById(empHistory.getId());
        EmploymentHistory updateEmpHistory = null;
        if(findEmpHistory.isPresent()) {
            updateEmpHistory = findEmpHistory.get();

            updateEmpHistory.setPosition(empHistory.getPosition());
            updateEmpHistory.setCompanyName(empHistory.getCompanyName());
            updateEmpHistory.setJobDesc(empHistory.getJobDesc());
            updateEmpHistory.setBeginDate(empHistory.getBeginDate());
            updateEmpHistory.setEndDate(empHistory.getEndDate());

            empHistoryRepository.save(empHistory);
        }
        return empHistory;
    }

    @Override
    public void deleteEmploymentHistoryById(Integer id) {
         empHistoryRepository.deleteById(id);
    }
}
