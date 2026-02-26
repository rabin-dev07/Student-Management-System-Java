import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    dao.addStudent(new Student(name, email));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    for (Student s : students) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();

                    dao.updateStudent(updateId, newName, newEmail);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = scanner.nextInt();
                    dao.deleteStudent(deleteId);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}