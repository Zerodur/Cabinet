package ru.homework.cabinet.DAO;

import ru.homework.cabinet.entities.Document;

public interface DocumentDao {
    Document getDocument(Long id);
    void editDocument(Document document);
    void editDocument(Long id);
    void removeDocument(Document document);
    void removeDocument(Long id);
    void addDocument(Document document);
}
