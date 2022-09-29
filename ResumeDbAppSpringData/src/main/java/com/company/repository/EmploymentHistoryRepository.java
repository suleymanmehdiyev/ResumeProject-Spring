package com.company.repository;

import com.company.model.EmploymentHistory;
import com.company.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmploymentHistoryRepository extends JpaRepository<EmploymentHistory,Integer> {
    List<EmploymentHistory> findByUserId(User userId);
}
