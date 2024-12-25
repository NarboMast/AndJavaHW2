package db;

import busTickets.BusTicket;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import users.User;

import java.util.Collections;
import java.util.List;

public class TicketDbHibernate {
    private static SessionFactory factory;

    public TicketDbHibernate() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public void closeFactory(){
        if(factory.isOpen()) {
            factory.close();
        }
    }

    public void addUser(User user) {
        userNotNull(user);

        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Integer id = (Integer) session.save(user);
            tx.commit();
            System.out.println("User with id: " + id + " added successfully");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException("Could not save user");
        } finally {
            session.close();
        }
    }

    public void addBusTicket(BusTicket busTicket, User user) {
        busTicketNotNull(busTicket);
        userNotNull(user);

        busTicket.setUserId(user.getId());
        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Integer id = (Integer) session.save(busTicket);
            tx.commit();
            System.out.println("BusTicket with id: " + id + " added successfully");
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException("Could not save busTicket");
        } finally {
            session.close();
        }
    }

    public BusTicket fetchTicketById(int id) {
        Session session = factory.openSession();
        BusTicket busTicket = null;

        try {
            busTicket = session.get(BusTicket.class, id);

            if (busTicketNotNull(busTicket)) {
                System.out.println("Ticket fetched successfully: " + busTicket);
            } else {
                System.out.println("Ticket with ID " + id + " not found.");
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage() + " Exception in fetchTicketById");
        } finally {
            session.close();
        }
        return busTicket;
    }

    public List<BusTicket> fetchTicketsByUserId(int userId) {
        userNotNull(fetchUserById(userId));

        String hql = "FROM BusTicket WHERE userId = :userId";
        try (Session session = factory.openSession()) {
            Query<BusTicket> query = session.createQuery(hql, BusTicket.class);
            query.setParameter("userId", userId);

            System.out.println("Fetched tickets: " + query.list());

            return query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public User fetchUserById(int id) {
        Session session = factory.openSession();
        User user = null;

        try{
            user = session.get(User.class, id);
            if (userNotNull(user)) {
                System.out.println("User fetched successfully: " + user);
            } else {
                System.out.println("User with ID " + id + " not found.");
            }
        } catch (HibernateException e) {
            System.out.println(e.getMessage() + " Exception in fetchUserById");
        } finally {
            session.close();
        }
        return user;
    }

    public void deleteUserTickets(int id) {
        Session session = factory.openSession();
        Transaction tx = null;
        User user = fetchUserById(id);

        if (userNotNull(user)) {
            List<BusTicket> tickets = fetchTicketsByUserId(user.getId());
            try {
                tx = session.beginTransaction();
                session.delete(fetchUserById(id));
                if(!tickets.isEmpty()) {
                    for (BusTicket busTicket : tickets) {
                        session.delete(busTicket);
                    }
                }
                tx.commit();
                System.out.println("User with id: " + id + " deleted successfully");
            } catch (HibernateException e) {
                if (tx != null) tx.rollback();
                System.err.println(e.getMessage());
                throw new RuntimeException("Could not delete user");
            }
        }
    }

    public boolean userNotNull(User user){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }
        return true;
    }
    public boolean busTicketNotNull(BusTicket busTicket){
        if (busTicket == null) {
            throw new IllegalArgumentException("BusTicket cannot be null");
        }
        return true;
    }
}
