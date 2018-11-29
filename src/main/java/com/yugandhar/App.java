package com.yugandhar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        Configuration configuration;
        SessionFactory sessionFactory;
        Session session;
        Transaction transaction;

        Alien alien = new Alien();
        Spaceships spaceships = new Spaceships();

        alien.setId(06);
        alien.setName("Yugandhar");
        alien.setColor("brown");


        spaceships.setShipId(69);
        spaceships.setShipName("Flying Machine");
//        spaceships.setAlien(alien);

        alien.setSpaceships(spaceships);

        try {

            configuration = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Spaceships.class);

            sessionFactory = configuration.buildSessionFactory();

            session =sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(alien);
            session.save(spaceships);

            transaction.commit();

            session.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            //session.close();
        }
    }
}
