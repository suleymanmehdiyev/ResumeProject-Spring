package com.company.service.inter;

import com.company.model.EmploymentHistory;
import com.company.model.User;

import java.util.List;
import java.util.Optional;

public interface EmploymentHistoryServiceInter {
    List<EmploymentHistory> getAllEmploymentHistory(User userId);
    Optional<EmploymentHistory> getEmploymentHistoryById(Integer id);
    EmploymentHistory addEmploymentHistory(EmploymentHistory employmentHistory);
    EmploymentHistory updateEmploymentHistory(EmploymentHistory employmentHistory);
    void deleteEmploymentHistoryById(Integer id);
}
