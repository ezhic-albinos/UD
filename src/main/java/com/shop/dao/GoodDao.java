package com.shop.dao;

import com.shop.model.Good;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository

public class GoodDao
{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(GoodDao.class));

    @SuppressWarnings("unchecked")
    public List<Good> listGood()
    {
        Session session = this.sessionFactory.openSession();
        List<Good> goodList = session.createQuery("SELECT p FROM Good p").list();
        for (Good p : goodList)
        {
            logger.info(p.toString());
        }
        session.close();
        return goodList;
    }

    //обновление БД
    public void UpdateGood(Good newGood)
    {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.update(newGood);
        session.getTransaction().commit();
        session.close();
    }

    //добавление в БД
    public void AddGood(Good newGood)
    {
        Session session = this.sessionFactory.openSession();
            session.beginTransaction();
            session.save(newGood);
            session.getTransaction().commit();
        session.close();
    }

    //удаление из БД
    public void DeleteGood(Good newGood)
    {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(newGood);
        session.getTransaction().commit();
        session.close();
    }
//запрос на вывод всех купленный товаров определенного художника с подсчетом суммарной выручки за них
@SuppressWarnings("unchecked")
    public List<Good> ExpensiveListGood()
    {
        Session session = this.sessionFactory.openSession();
        List<Good> goodList = session.createQuery(
                "FROM Good g WHERE g.creator = 2 AND g.GoodId = ANY (SELECT o.GoodId FROM Ordered_good o)").list();
        for (Good p : goodList)
        {
            logger.info(p.toString());
        }
        session.close();
        return goodList;
    }
    @SuppressWarnings("unchecked")
    public List<Good> ListGoodPrice()
    {
        Session session = this.sessionFactory.openSession();
        List<Good> goodList = session.createQuery("SELECT s FROM Good s WHERE s.Price > (SELECT AVG(s.Price) FROM Good s)").list();
        for(Good p : goodList)
        {
            logger.info(p.toString());
        }
        session.close();
        return goodList;
    }
}
