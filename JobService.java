package service;


import beans.Job;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class JobService {

    public void createJob(Job job) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(job);
            transaction.commit();
        } catch (Exception e) {
            //if (transaction != null)
           // {transaction.rollback();}
            e.printStackTrace();
        }
    }

    public List<Job> getAllJobs() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Job", Job.class).list();
        }
    }

    public void updateJob(String id, Job jobDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Job job = session.get(Job.class, id);
            if (job != null) {
                job.setJobTitle(jobDetails.getJobTitle());
                job.setJobDescription(jobDetails.getJobDescription());
                job.setEmployer(jobDetails.getEmployer());
                session.update(job);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteJob(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Job job = session.get(Job.class, id);
            if (job != null) {
                session.delete(job);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

}
