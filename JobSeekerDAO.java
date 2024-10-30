package dao;

import beans.JobSeeker;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class JobSeekerDAO   {

    private SessionFactory factory;

    public JobSeekerDAO() {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public void createJobSeeker(JobSeeker jobSeeker) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(jobSeeker);
        tx.commit();
        session.close();
    }

    public List<JobSeeker> getAllJobSeekers() {
        Session session = factory.openSession();
        List<JobSeeker> jobSeekers = session.createQuery("FROM JobSeeker", JobSeeker.class).list();
        session.close();
        return jobSeekers;
    }

    public JobSeeker getJobSeekerById(String id) {
        Session session = factory.openSession();
        JobSeeker jobSeeker = session.get(JobSeeker.class, id);
        session.close();
        return jobSeeker;
    }

    public void updateJobSeeker(JobSeeker jobSeeker) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(jobSeeker);
        tx.commit();
        session.close();
    }

    public void deleteJobSeeker(String id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        JobSeeker jobSeeker = session.get(JobSeeker.class, id);
        if (jobSeeker != null) {
            session.delete(jobSeeker);
        }
        tx.commit();
        session.close();
    }
}

