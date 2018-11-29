package com.yugandhar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {

        Alien alien ;
        try {

           Configuration configuration = new Configuration().configure().addAnnotatedClass(Alien.class);

            SessionFactory sessionFactory = configuration.buildSessionFactory();

            Session session =sessionFactory.openSession();

            Transaction transaction = session.beginTransaction();

            alien = session.get(Alien.class,"1");

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
