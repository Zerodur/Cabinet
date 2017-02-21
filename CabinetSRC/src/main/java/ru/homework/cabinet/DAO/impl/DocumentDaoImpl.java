package ru.homework.cabinet.DAO.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.homework.cabinet.DAO.DocumentDao;
import ru.homework.cabinet.entities.Document;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public DocumentDaoImpl() {
    }

    public Document getDocument(Long id) {
        return sessionFactory.getCurrentSession().get(Document.class, id);
    }

    public void editDocument(Document document) {
        sessionFactory.getCurrentSession().update(document);
    }

    public void editDocument(Long id) {
        Document document = sessionFactory.getCurrentSession().get(Document.class, id);
        sessionFactory.getCurrentSession().update(document);
    }

    public void removeDocument(Document document) {
        sessionFactory.getCurrentSession().delete(document);
    }

    public void removeDocument(Long id) {
        Document document = sessionFactory.getCurrentSession().get(Document.class, id);
        sessionFactory.getCurrentSession().delete(document);
    }

    public void addDocument(Document document) {
        sessionFactory.getCurrentSession().save(document);
    }
}
