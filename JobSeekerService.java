package service;

import beans.JobSeeker;
import org.hibernate.Session;
import org.hibernate.Transaction;


import util.HibernateUtil;

import java.util.List;

public class JobSeekerService {

    public void createJobSeeker(JobSeeker jobSeeker) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(jobSeeker);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<JobSeeker> getAllJobSeekers() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from JobSeeker", JobSeeker.class).list();
        }
    }

    public void updateJobSeeker(String id, JobSeeker jobSeekerDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            JobSeeker jobSeeker = session.get(JobSeeker.class, id);
            if (jobSeeker != null) {
                jobSeeker.setName(jobSeekerDetails.getName());
                jobSeeker.setEmail(jobSeekerDetails.getEmail());
                jobSeeker.setPassword(jobSeekerDetails.getPassword());
                jobSeeker.setResume(jobSeekerDetails.getResume());
                session.update(jobSeeker);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteJobSeeker(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            JobSeeker jobSeeker = session.get(JobSeeker.class, id);
            if (jobSeeker != null) {
                session.delete(jobSeeker);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}

