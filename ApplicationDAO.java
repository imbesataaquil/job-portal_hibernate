package dao;

import beans.Application;
import beans.Employer;
import beans.Job;
import beans.JobSeeker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ApplicationDAO  {

    private SessionFactory factory;

    public ApplicationDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void createApplication(Application application) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(application);
        tx.commit();
        session.close();
    }

    public List<Application> getAllApplication() {
        Session session = factory.openSession();
        List<Application> applications = session.createQuery("FROM Application", Application.class).list();
        session.close();
        return applications;
    }

    public Application getApplicationById(String id) {
        Session session = factory.openSession();
        Application application = session.get(Application.class, id);
        session.close();
        return application;
    }

    public void updateApplication(Application application) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(application);
        tx.commit();
        session.close();
    }

    public void deleteApplication(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Application application = session.get(Application.class, id);
        if (application != null) {
            session.delete(application);
        }
        tx.commit();
        session.close();
    }
}


