package dao;

import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private final String url = "jdbc:mysql://localhost:3306/student_db";
    private final String username = "root";      // change if needed
    private final String password = "drabin123";      // change to your MySQL password

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // CREATE
    public void addStudent(Student student) {
        String sql = "INSERT INTO students(name, email) VALUES(?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());

            stmt.executeUpdate();
            System.out.println("✅ Student added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // UPDATE
    public void updateStudent(int id, String name, String email) {
        String sql = "UPDATE students SET name = ?, email = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);

            stmt.executeUpdate();
            System.out.println("✅ Student updated successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Student deleted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}