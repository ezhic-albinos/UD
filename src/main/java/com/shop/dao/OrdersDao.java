package com.shop.dao;

import com.shop.model.Orders;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository

public class OrdersDao
{
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(OrdersDao.class));

    @SuppressWarnings("unchecked")
    public List<Orders> listOrders()
    {
        Session session = this.sessionFactory.openSession();
        List<Orders> ordersList = session.createQuery("SELECT p FROM Orders p").list();
        for (Orders p : ordersList)
        {
            logger.info(p.toString() + p.getClients());
        }
        session.close();
        return ordersList;
    }

    //обновление БД
    public void UpdateOrders(Orders newOrders)
    {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.update(newOrders);
        session.getTransaction().commit();
        session.close();
    }

    //добавление в БД
    public void AddOrders(Orders newOrders)
    {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.save(newOrders);
        session.getTransaction().commit();
        session.close();
    }

    //удаление из БД
    public void DeleteOrders(Orders newOrders)
    {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(newOrders);
        session.getTransaction().commit();
        session.close();
    }
}
