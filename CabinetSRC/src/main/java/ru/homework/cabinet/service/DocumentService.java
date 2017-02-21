package ru.homework.cabinet.service;

import ru.homework.cabinet.entities.Document;

public interface DocumentService {
    Document getDocument(Long id);
    void editDocument(Document document);
    void editDocument(Long id);
    void removeDocument(Document document);
    void removeDocument(Long id);
    void addDocument(Document document);
}
