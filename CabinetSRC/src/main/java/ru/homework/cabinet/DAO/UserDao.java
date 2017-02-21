package ru.homework.cabinet.DAO;

import ru.homework.cabinet.entities.Document;
import ru.homework.cabinet.entities.User;

import java.util.List;

public interface UserDao {
    User getUserById(Long id);
    User getUserByName(String name);
    void addUser(User user);
    void editUser(User user);
    List<Document> getDocumentList(User user);
}
