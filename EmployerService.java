package service;

import beans.Employer;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import java.util.List;

public class EmployerService {

    public void createEmployer(Employer employer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(employer);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Employer> getAllEmployer() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Employer", Employer.class).list();
        }
    }

    public void updateEmployer(String id, Employer employerDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employer employer = session.get(Employer.class, id);
            if (employer != null) {
                employer.setName(employerDetails.getName());
                employer.setEmail(employerDetails.getEmail());
                employer.setPassword(employerDetails.getPassword());
                session.update(employer);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteEmployer(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employer employer = session.get(Employer.class, id);
            if (employer != null) {
                session.delete(employer);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
