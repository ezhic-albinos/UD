package com.shop;

import com.shop.model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

public class Runner
{

    @Test
    public void crud()
    {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        //Orders clients = new Orders();
       // clients.setFamilia("March");
       // clients.setName("Lisa");
        //clients.setTelephone("675742");
        //clients.setPassport("050489");

        /*Clients clients1 = new Clients();
        clients1.setFamilia("May");
        clients1.setName("Alice");
        clients1.setCountry("Dania");
        clients1.setDateOfBirth("23.05.67");
        creator1.setStyle("draw");

        Creator creator2 = new Creator();
        creator2.setFamilia("September");
        creator2.setName("John");
        creator2.setCountry("UK");
        creator2.setDateOfBirth("15.09.98");
        creator2.setStyle("sleep");*/

        read(session);
        //create(session, clients);
        //create(session, creator1);
        //create(session, creator2);
        //find(session, 2);

        /*clients.setFamilia("April");
        clients.setPassport("04122008");
        update(session, clients);

        read(session);
        delete(session, clients);
*/
        session.close();
    }

   /*private void create(Session session, Clients clients)
    {
        session.beginTransaction();
        session.save(clients);
        session.getTransaction().commit();
    }*/

    private void read(Session session)
    {
        List<Orders> ordersList = session.createQuery("SELECT s FROM Orders s").list();
        for (Orders s : ordersList)
        {
            System.out.println("List:" + s);
        }
    }

    /*public void find(Session session, int id)
    {
        Creator c = (Creator) session.load(Creator.class, id);
        System.out.println("++" + c.getFamilia());
    }*/

    /*public void delete(Session session, Creator clients)
    {
        //Creator c = (Creator) session.load(Creator.class, id);
        session.beginTransaction();
        //session.delete(c);
        session.delete(clients;
        session.getTransaction().commit();
    }

    public void update(Session session, Creator newCreator)
    {
        session.beginTransaction();
        session.update(newCreator);
        session.getTransaction().commit();
    }*/
}

