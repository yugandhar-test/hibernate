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

        Spaceships spaceships1 = new Spaceships();
        Spaceships spaceships2 = new Spaceships();

        spaceships1.setShipId(93);
        spaceships1.setShipName("Drone");

        spaceships2.setShipId(69);
        spaceships2.setShipName("Flying Machine");

        alien.setId(06);
        alien.setName("Yugandhar");
        alien.setColor("brown");
        alien.getSpaceships().add(spaceships1);
        alien.getSpaceships().add(spaceships2);

        try {

            configuration = new Configuration().configure().addAnnotatedClass(Alien.class).addAnnotatedClass(Spaceships.class);

            sessionFactory = configuration.buildSessionFactory();

            session =sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(alien);
            session.save(spaceships1);
            session.save(spaceships2);

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
