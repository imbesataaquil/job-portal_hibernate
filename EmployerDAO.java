package dao;

import beans.Employer;
import beans.JobSeeker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployerDAO   {

    private SessionFactory factory;

    public EmployerDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void createEmployer(Employer employer) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employer);
        tx.commit();
        session.close();
    }

    public List<Employer> getAllEmployers() {
        Session session = factory.openSession();
        List<Employer> employers = session.createQuery("FROM Employer", Employer.class).list();
        session.close();
        return employers;
    }

    public Employer getEmployerById(String id) {
        Session session = factory.openSession();
        Employer employer = session.get(Employer.class, id);
        session.close();
        return employer;
    }

    public void updateEmployer(Employer employer) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(employer);
        tx.commit();
        session.close();
    }

    public void deleteEmployer(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employer employer = session.get(Employer.class, id);
        if (employer != null) {
            session.delete(employer);
        }
        tx.commit();
        session.close();
    }
}

