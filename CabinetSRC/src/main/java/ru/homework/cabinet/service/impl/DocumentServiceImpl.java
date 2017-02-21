package ru.homework.cabinet.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.cabinet.DAO.DocumentDao;
import ru.homework.cabinet.entities.Document;
import ru.homework.cabinet.service.DocumentService;


@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Transactional
    public Document getDocument(Long id) {
        return documentDao.getDocument(id);
    }

    @Transactional
    public void editDocument(Document document) {
        documentDao.editDocument(document);
    }

    @Transactional
    public void editDocument(Long id) {
        documentDao.editDocument(id);
    }

    @Transactional
    public void removeDocument(Document document) {
        documentDao.removeDocument(document);
    }

    @Transactional
    public void removeDocument(Long id) {
        documentDao.removeDocument(id);
    }

    @Transactional
    public void addDocument(Document document) {
        documentDao.addDocument(document);
    }
}
