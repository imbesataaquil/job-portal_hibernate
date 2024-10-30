package main;

import beans.Application;
import beans.Employer;
import beans.Job;
import beans.JobSeeker;
import service.ApplicationService;
import service.EmployerService;
import service.JobSeekerService;
import service.JobService;


import java.util.List;
import java.util.Scanner;

import static main.Main.*;

public class AllOperations {
    static JobSeekerService jobSeekerService = new JobSeekerService();
    static EmployerService employerService = new EmployerService();
    static JobService jobService = new JobService();
    static ApplicationService applicationService = new ApplicationService();

    static Scanner sc = new Scanner(System.in);

    public static Void JobSeekerOperations() throws Exception {
        while (true) {
            System.out.println("Press 1. Add Job Seeker\nPress 2. View All Job Seekers\nPress 3. Update Job Seeker\nPress 4. Delete Job Seeker\nPress 5. Return To Main Menu\nPress 6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    addJobSeeker();
                    break;
                case 2:
                    viewAllJobSeekers();
                    break;
                case 3:
                    updateJobSeeker();
                    break;
                case 4:
                    deleteJobSeeker();
                    break;
                case 5:
                    mainOps();
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
            }

        }
    }

    public static void addJobSeeker() {
        System.out.println("Enter Job Seeker ID:");
        String id = sc.nextLine();
        System.out.println("Enter Job Seeker Name:");
        String name = sc.nextLine();
        System.out.println("Enter Job Seeker Email:");
        String email = sc.nextLine();
        System.out.println("Enter Job Seeker Password:");
        String password = sc.nextLine();
        System.out.println("Enter Resume:");
        String resume = sc.nextLine();

        JobSeeker jobSeeker = new JobSeeker(id, name, email, password, resume);
        jobSeekerService.createJobSeeker(jobSeeker);
        System.out.println("Job Seeker added successfully.");
    }

    public static void viewAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerService.getAllJobSeekers();
        for (JobSeeker js : jobSeekers) {
            System.out.println(js);
        }

    }

    public static void updateJobSeeker() {
        System.out.println("Enter Job Seeker ID to update:");
        String id = sc.nextLine();

        System.out.println("Enter new Job Seeker Name:");
        String name = sc.nextLine();
        System.out.println("Enter new Job Seeker Email:");
        String email = sc.nextLine();
        System.out.println("Enter new Job Seeker Password:");
        String password = sc.nextLine();
        System.out.println("Enter new Resume:");
        String resume = sc.nextLine();

        JobSeeker jobSeekerDetails = new JobSeeker(id, name, email, password, resume);
        jobSeekerService.updateJobSeeker(id, jobSeekerDetails);
        System.out.println("Job Seeker updated successfully.");
    }

    public static void deleteJobSeeker() {
        System.out.println("Enter Job Seeker ID to delete:");
        String id = sc.nextLine();
        jobSeekerService.deleteJobSeeker(id);
        System.out.println("Job Seeker deleted successfully.");
    }

    public static Void EmployerOperations() throws Exception {
        while (true) {
            System.out.println("Press 1. Add Employer\nPress 2. View All Employers\nPress 3. Update Employer\nPress 4. Delete Employer\nPress 5. Return To Main Menu\nPress 6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    addEmployer();
                    break;
                case 2:
                    viewAllEmployers();
                    break;
                case 3:
                    updateEmployer();
                    break;
                case 4:
                    deleteEmployer();
                    break;
                case 5:
                    mainOps();
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
            }

        }
    }

    public static void addEmployer() {
        System.out.println("Enter Employer ID:");
        String id = sc.nextLine();
        System.out.println("Enter Employer Name:");
        String name = sc.nextLine();
        System.out.println("Enter Employer Email:");
        String email = sc.nextLine();
        System.out.println("Enter Employer Password:");
        String password = sc.nextLine();

        Employer employer = new Employer(id, name, email, password);
        employerService.createEmployer(employer);
        System.out.println("Employer added successfully.");
    }

    public static void viewAllEmployers() {
        List<Employer> employers = employerService.getAllEmployer();
        for (Employer e : employers) {
            System.out.println(e);
        }
    }

    public static void updateEmployer() {
        System.out.println("Enter Employer ID to update:");
        String id = sc.nextLine();
        System.out.println("Enter new Employer Name:");
        String name = sc.nextLine();
        System.out.println("Enter new Employer Email:");
        String email = sc.nextLine();
        System.out.println("Enter new Employer Password:");
        String password = sc.nextLine();

        Employer employerDetails = new Employer(id, name, email, password);
        employerService.updateEmployer(id, employerDetails);
        System.out.println("Employer updated successfully.");
    }

    public static void deleteEmployer() {
        System.out.println("Enter Employer ID to delete:");
        String id = sc.nextLine();
        employerService.deleteEmployer(id);
        System.out.println("Employer deleted successfully.");
    }

    public static Void JobOperations() throws Exception {
        while (true) {
            System.out.println("Press 1. Add Job \nPress 2. View All Job \nPress 3. Update Job \nPress 4. Delete Job \nPress 5. Return To Main Menu\nPress 6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    addJob();
                    break;
                case 2:
                    viewAllJob();
                    break;
                case 3:
                    updateJob();
                    break;
                case 4:
                    deleteJob();
                    break;
                case 5:
                    mainOps();
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
            }

        }
    }
    public static void addJob() {
        System.out.println("Enter Job ID:");
        String id = sc.nextLine();
        System.out.println("Enter Job Title:");
        String jobTitle = sc.nextLine();
        System.out.println("Enter Job Description:");
        String jobDescription = sc.nextLine();
        System.out.println("Enter Employer:");
        String  employer=sc.nextLine();

        Job job = new Job(id,jobTitle,jobDescription,employer);
        jobService.createJob(job);
        System.out.println("Job added successfully.");
    }

    public static void viewAllJob() {
        List<Job> jobs = jobService.getAllJobs();
        for (Job j : jobs) {
            System.out.println(j);
        }
    }

    public static void updateJob() {
        System.out.println("Enter Job ID to update:");
        String id = sc.nextLine();
        System.out.println("Enter new Job Title:");
        String jobTitle = sc.nextLine();
        System.out.println("Enter new Job Description:");
        String jobDescription = sc.nextLine();


        Job jobDetails = new Job(id, jobTitle,jobDescription);
        jobService.updateJob(id, jobDetails);
        System.out.println("Job updated successfully.");
    }

    public static void deleteJob() {
        System.out.println("Enter Job ID to delete:");
        String id = sc.nextLine();
        jobService.deleteJob(id);
        System.out.println("Job deleted successfully.");
    }
    public static Void ApplicationOperations() throws Exception {
        while (true) {
            System.out.println("Press 1. Add Application\nPress 2. View All Application\nPress 3. Update Application\nPress 4. Delete Application\nPress 5. Return To Main Menu\nPress 6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // Clear the buffer

            switch (choice) {
                case 1:
                    addApplication();
                    break;
                case 2:
                    viewAllApplication();
                    break;
                case 3:
                    updateApplication();
                    break;
                case 4:
                    deleteApplication();
                    break;
                case 5:
                    mainOps();
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
            }

        }
    }
    public static void addApplication() {
        System.out.println("Enter Application ID:");
        String id = sc.nextLine();
        System.out.println("Enter Job Seeker:");
        String jobSeeker = sc.nextLine();
        System.out.println("Enter Job :");
        String job = sc.nextLine();
        System.out.println("Enter Status:");
        String status = sc.nextLine();


        Application application = new Application(id,jobSeeker,job,status);
        applicationService.createApplication(application);
        System.out.println("Application added successfully.");
    }

    public static void viewAllApplication() {
        List<Application> applications = applicationService.getAllApplication();
        for (Application a : applications) {
            System.out.println(a);
        }
    }

    public static void updateApplication() {
        System.out.println("Enter Application ID to update:");
        String id = sc.nextLine();
        System.out.println("Enter new Job Seeker:");
        String jobSeeker = sc.nextLine();
        System.out.println("Enter new Job :");
        String job = sc.nextLine();
        System.out.println("Enter new Status:");
        String status=sc.nextLine();

        Application applicationDetails = new Application(id, jobSeeker,job,status);
        applicationService.updateApplication(id, applicationDetails);
        System.out.println("Application updated successfully.");
    }

    public static void deleteApplication() {
        System.out.println("Enter Application ID to delete:");
        String id = sc.nextLine();
        applicationService.deleteApplication(id);
        System.out.println("Application deleted successfully.");
    }





















































































}
