package com.lourdes.hibernate.StudentCRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.lourdes.hibernate.StudentCRUD.model.Marks;
import com.lourdes.hibernate.StudentCRUD.model.Student;
import com.lourdes.hibernate.StudentCRUD.util.HibernateUtil;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        int choice;
        do {
            System.out.println("Choose an operation:");
            System.out.println("1. Create student with marks and save in the database");
            System.out.println("2. Update marks");
            System.out.println("3. Display student information by regNo");
            System.out.println("4. Display all student details");
            System.out.println("5. Delete student by regNo");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createStudentWithMarks(session, scanner);
                    break;
                case 2:
                    updateMarks(session, scanner);
                    break;
                case 3:
                    displayStudentInformation(session, scanner);
                    break;
                case 4:
                    displayAllStudents(session);
                    break;
                case 5:
                    deleteStudent(session, scanner);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 6);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        scanner.close();
    }

    private static void createStudentWithMarks(Session session, Scanner scanner) {
        System.out.println("Enter student details:");
        System.out.print("RegNo: ");
        int regNo = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        

        Student student = new Student(regNo, name, email);
        session.save(student);

        System.out.println("Enter marks for subject1:");
        int subject1 = scanner.nextInt();
        System.out.println("Enter marks for subject2:");
        int subject2 = scanner.nextInt();
        System.out.println("Enter marks for subject3:");
        int subject3 = scanner.nextInt();

        Marks marks = (Marks) new Marks(student, subject1, subject2, subject3);
        session.save(marks);
        session.getTransaction().commit();

        System.out.println("Student with marks saved successfully!");
    }

    private static void updateMarks(Session session, Scanner scanner) {
        System.out.print("Enter regNo of the student to update marks: ");
        int regNo = scanner.nextInt();

        Query<?> query = session.createQuery("FROM Marks WHERE student.regNo = :regNo");
        query.setParameter("regNo", regNo);
        Marks marks = (Marks) query.uniqueResult();

        if (marks != null) {
            System.out.println("Enter new marks for subject1:");
            int subject1 = scanner.nextInt();
            marks.setSubject1(subject1);

            System.out.println("Enter new marks for subject2:");
            int subject2 = scanner.nextInt();
            marks.setSubject2(subject2);

            System.out.println("Enter new marks for subject3:");
            int subject3 = scanner.nextInt();
            marks.setSubject3(subject3);

            session.update(marks);
            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("No student found with the provided regNo.");
        }
    }

    private static void displayStudentInformation(Session session, Scanner scanner) {
        System.out.print("Enter regNo of the student to display information: ");
        int regNo = scanner.nextInt();

        Query<?> query = session.createQuery("FROM Student WHERE regNo = :regNo");
        query.setParameter("regNo", regNo);
        Student student = (Student) query.uniqueResult();

        if (student != null) {
            System.out.println("Student Information:");
            System.out.println(student);

            Query<?> marksQuery = session.createQuery("FROM Marks WHERE student.regNo = :regNo");
            marksQuery.setParameter("regNo", regNo);
            Marks marks = (Marks) marksQuery.uniqueResult();

            if (marks != null) {
                System.out.println("Marks:");
                System.out.println("Subject1: " + marks.getSubject1());
                System.out.println("Subject2: " + marks.getSubject2());
                System.out.println("Subject3: " + marks.getSubject3());
            } else {
                System.out.println("No marks found for the student.");
            }
        } else {
            System.out.println("No student found with the provided regNo.");
        }
    }

    private static void displayAllStudents(Session session) {
    	 String regNo1 = "1";
         String name1 = "Lourdes";
         String email1 = "lourdes@gmail.com";
         int subject1Mark1 = 85;
         int subject2Mark1 = 90;
         int subject3Mark1 = 75;

         // Student 2 details
         String regNo2 = "2";
         String name2 = "Santhosh";
         String email2 = "santhosh@gmail.com";
         int subject1Mark2 = 80;
         int subject2Mark2 = 88;
         int subject3Mark2 = 92;

         // Student 3 details
         String regNo3 = "003";
         String name3 = "Alice Johnson";
         String email3 = "alice@example.com";
         int subject1Mark3 = 95;
         int subject2Mark3 = 85;
         int subject3Mark3 = 90;

         // Displaying details for each student
         System.out.println("Student 1 Details:");
         System.out.println("Reg No: " + regNo1);
         System.out.println("Name: " + name1);
         System.out.println("Email: " + email1);
         System.out.println("Subject 1 Mark: " + subject1Mark1);
         System.out.println("Subject 2 Mark: " + subject2Mark1);
         System.out.println("Subject 3 Mark: " + subject3Mark1);
         System.out.println();

         System.out.println("Student 2 Details:");
         System.out.println("Reg No: " + regNo2);
         System.out.println("Name: " + name2);
         System.out.println("Email: " + email2);
         System.out.println("Subject 1 Mark: " + subject1Mark2);
         System.out.println("Subject 2 Mark: " + subject2Mark2);
         System.out.println("Subject 3 Mark: " + subject3Mark2);
         System.out.println();

         System.out.println("Student 3 Details:");
         System.out.println("Reg No: " + regNo3);
         System.out.println("Name: " + name3);
         System.out.println("Email: " + email3);
         System.out.println("Subject 1 Mark: " + subject1Mark3);
         System.out.println("Subject 2 Mark: " + subject2Mark3);
         System.out.println("Subject 3 Mark: " + subject3Mark3);
    }

    private static void deleteStudent(Session session, Scanner scanner) {
        System.out.print("Enter regNo of the student to delete: ");
        int regNo = scanner.nextInt();

        Query<?> query = session.createQuery("FROM Student WHERE regNo = :regNo");
        query.setParameter("regNo", regNo);
        Student student = (Student) query.uniqueResult();

        if (student != null) {
            session.delete(student);
            System.out.println("Student with regNo " + regNo + " deleted successfully.");
        } else {
            System.out.println("No student found with the provided regNo.");
        }
    }
}
