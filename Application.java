package beans;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "application_id")
    private String applicationId;

    @ManyToOne
    @JoinColumn(name = "job_seeker_id", nullable = false)
    private JobSeeker jobSeeker;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @Column(name = "status")
    private String status;

    // Constructors, Getters, Setters
    public Application() {}

    public Application(String applicationId, JobSeeker jobSeeker, Job job, String status) {
        this.applicationId = applicationId;
        this.jobSeeker = jobSeeker;
        this.job = job;
        this.status = status;
    }

    public Application(String id, String jobSeeker, String job, String status) {
    }

    // getters and setters

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public JobSeeker getJobSeeker() {
        return jobSeeker;
    }

    public void setJobSeeker(JobSeeker jobSeeker) {
        this.jobSeeker = jobSeeker;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application{" +
                "applicationId='" + applicationId + '\'' +
                ", jobSeeker=" + jobSeeker +
                ", job=" + job +
                ", status='" + status + '\'' +
                '}';
    }
}

