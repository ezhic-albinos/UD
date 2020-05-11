package com.shop.dao;

import com.shop.model.Ordered_good;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository

public class Ordered_goodDao
{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(Ordered_goodDao.class));

    @SuppressWarnings("unchecked")
    public List<Ordered_good> listOrdered_good()
    {
        Session session = this.sessionFactory.openSession();
        List<Ordered_good> ordered_goodList = session.createQuery("SELECT p FROM Ordered_good p").list();
        for (Ordered_good p : ordered_goodList)
        {
            logger.info(p.toString());
        }
        session.close();
        return ordered_goodList;
    }
}
