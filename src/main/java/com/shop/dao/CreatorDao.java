package com.shop.dao;

import com.shop.model.Creator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class CreatorDao
{

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(CreatorDao.class));

    @SuppressWarnings("unchecked")
    public List<Creator> listCreator()
    {
        Session session = this.sessionFactory.openSession();
        List<Creator> creatorList = session.createQuery("SELECT p FROM Creator p").list();
        for (Creator p : creatorList)
        {
            logger.info(p.toString());
        }
        session.close();
        return creatorList;
    }

    //обновление БД
    public void UpdateCreator(Creator newCreator)
    {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.update(newCreator);
        session.getTransaction().commit();
        session.close();
    }

    //добавление в БД
    public void AddCreator(Creator newCreator)
    {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.save(newCreator);
        session.getTransaction().commit();
        session.close();

    }

    //удаление из БД
    public void DeleteCreator(Creator newCreator)
    {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(newCreator);
        session.getTransaction().commit();
        session.close();
    }
}
