package main;

import beans.JobSeeker;
import service.JobSeekerService;

import java.util.List;
import java.util.Scanner;

import static main.AllOperations.*;

public class Main {

    static Scanner sc=new Scanner(System.in);

    public static void mainOps() throws Exception {
        while (true){
            System.out.println("Press 1.Job Seeker Details\nPress 2.Employer Details"
                    +"\nPress 3.Job Details\nPress 4.Application Details\nPress 5.Exit");
            int input = sc.nextInt();

            switch (input){
                case 1:
                    JobSeekerOperations();
                    System.out.println("===================================");
                    break;

                case 2:
                    EmployerOperations();
                    System.out.println("===================================");
                    break;

                case 3:
                    JobOperations();
                    System.out.println("===================================");
                    break;

                case 4:
                    ApplicationOperations();
                    System.out.println("===================================");
                    break;

                case 5:
                    System.exit(0);
                default:
                    System.out.println("wrong input");
            }

        }
    }

    public static void main(String[] args) throws Exception {
        mainOps();
    }
}


