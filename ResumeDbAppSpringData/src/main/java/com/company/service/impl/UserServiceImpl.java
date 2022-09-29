package com.company.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserDAOInter;
import com.company.model.User;
import com.company.repository.UserRepository;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInter {
    private UserDAOInter userDAO;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl( UserDAOInter userDAO, UserRepository userRepository) {
        this.userDAO = userDAO;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllNameAndSurname(String uname, String surname, String patronymic) {
        return userDAO.getAllNameAndSurnameAndPatronymic(uname,surname,patronymic);
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    private BCrypt.Hasher bCrypt = BCrypt.withDefaults();


    @Override
    public User addUser(User u) {
        u.setPassword(bCrypt.hashToString(4, u.getPassword().toCharArray()));
        return userRepository.save(u);
    }

    @Override
    @Transactional
    public User updateUser(User u) {
        return userDAO.updateUser(u);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
