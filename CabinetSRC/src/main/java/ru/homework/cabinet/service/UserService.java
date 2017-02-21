package ru.homework.cabinet.service;

import ru.homework.cabinet.entities.Document;
import ru.homework.cabinet.entities.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    User getUserByName(String name);
    void addUser(User user);
    void editUser(User user);
    List<Document> getDocumentList(User user);
}
