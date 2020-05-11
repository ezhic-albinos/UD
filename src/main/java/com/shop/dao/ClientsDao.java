package com.shop.dao;
import com.shop.model.Clients;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Logger;

@Repository
public class ClientsDao
{

    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    Logger logger = Logger.getLogger(String.valueOf(ClientsDao.class));

    @SuppressWarnings("unchecked")
    public List<Clients> listClients()
    {
        Session session = this.sessionFactory.openSession();
        List<Clients> clientsList = session.createQuery("SELECT s FROM Clients s").list();
        for (Clients p : clientsList)
        {
            logger.info(p.toString());
        }
        session.close();
        return clientsList;
    }

    //обновление БД
    public void UpdateClients(Clients newClients)
    {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.update(newClients);
        session.getTransaction().commit();
        session.close();
    }

    //добавление в БД
    public void AddClients(Clients newClients)
    {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.save(newClients);
        session.getTransaction().commit();
        session.close();
    }

    //удаление из БД
    public void DeleteClients(Clients newClients)
    {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(newClients);
        session.getTransaction().commit();
        session.close();
    }
}
