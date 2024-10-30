package service;

import beans.Application;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import java.nio.channels.OverlappingFileLockException;
import java.util.List;

public class ApplicationService {

    public void createApplication(Application application) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(application);
            transaction.commit();
        } catch (Exception e) {
            //if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Application> getAllApplication() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Application", Application.class).list();
        }
    }

    public void updateApplication(String id, Application applicationDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Application application = session.get(Application.class, id);
            if (application != null) {
                application.setJob(applicationDetails.getJob());
                application.setStatus(applicationDetails.getStatus());
                application.setJobSeeker(applicationDetails.getJobSeeker());
                session.update(application);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteApplication(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Application application= session.get(Application.class, id);
            if (application != null) {
                session.delete(application);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
