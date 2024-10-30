package dao;

import beans.Employer;
import beans.Job;
import beans.JobSeeker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class JobDAO  {

    private SessionFactory factory;

    public JobDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void createJob(Job job) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(job);
        tx.commit();
        session.close();
    }

    public List<Job> getAllJobs() {
        Session session = factory.openSession();
        List<Job> jobs = session.createQuery("FROM Job", Job.class).list();
        session.close();
        return jobs;
    }

    public Job getJobByName(String name) {
        Session session = factory.openSession();
        Job job = session.get(Job.class, name);
        session.close();
        return job;
    }

    public void updateJob(Job job) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(job);
        tx.commit();
        session.close();
    }

    public void deleteJob(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Job job = session.get(Job.class, id);
        if (job != null) {
            session.delete(job);
        }
        tx.commit();
        session.close();
    }
}


