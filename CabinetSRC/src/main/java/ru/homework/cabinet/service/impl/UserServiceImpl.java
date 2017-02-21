package ru.homework.cabinet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.cabinet.DAO.UserDao;
import ru.homework.cabinet.entities.Document;
import ru.homework.cabinet.entities.User;
import ru.homework.cabinet.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public User getUser(Long id) {
        return userDao.getUserById(id);
    }

    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void editUser(User user) {
        userDao.editUser(user);
    }

    public List<Document> getDocumentList(User user) {

        return null;
    }

}
