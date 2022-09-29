package com.company.service.inter;

import com.company.model.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceInter {
    List<User> getAll();
    List<User> getAllNameAndSurname(String name,String surname,String patronymic);


    Optional<User> getById(int id);
    User addUser(User u);
    User updateUser(User u);
    void deleteUser(int id);
    User findByUserEmail(String email);
}
