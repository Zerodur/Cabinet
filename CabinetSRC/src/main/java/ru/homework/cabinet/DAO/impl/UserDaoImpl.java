package ru.homework.cabinet.DAO.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.homework.cabinet.DAO.UserDao;
import ru.homework.cabinet.entities.Document;
import ru.homework.cabinet.entities.User;

import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public UserDaoImpl() {
    }

    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

//    public User getUserByName(String name) {
//        User user = (User)sessionFactory.getCurrentSession()
//                .createCriteria(User.class).add(Restrictions.eq("name", name)).uniqueResult();
//
//        return user;
//    }

    public User getUserByName(String name) {
        String hql = "FROM User U WHERE U.name = '" + name + "'";
        User user =(User) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
        return user;
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void editUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public List<Document> getDocumentList(User user) {

        return null;
    }
}
