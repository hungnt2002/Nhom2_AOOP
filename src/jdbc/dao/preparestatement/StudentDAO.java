package jdbc.dao.preparestatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dao.DAOInterface;
import jdbc.database.JDBCUtil;
import jdbc.model.Student;

public class StudentDAO implements DAOInterface<Student> {

    private Connection connection;
    private String sql;
    private PreparedStatement preparedStatement;

    @Override
    public void insert(Student student) {

        try {
            // Bước 1: tạo kết nối đến CSDL
            connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            sql = "INSERT INTO tblStudent (mssv, name, age, diemTrungBinh) " +
                    " VALUES (?, ?, ?, ?)";

            // Bước 3: tạo ra đối tượng PreparedStatement

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getMssv());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setDouble(4, student.getDiemTrungBinh());

            int result = preparedStatement.executeUpdate();
            System.out.printf("Co %d dong duoc them vao \n", result);

            // Bước 4:
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Insert fail");
        }

    }

    @Override
    public void update(Student student) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            sql = "UPDATE tblStudent " +
                    "SET name=?, age=?, diemTrungBinh=?" +
                    " WHERE mssv=?";

            // Bước 3: tạo ra đối tượng PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setDouble(3, student.getDiemTrungBinh());
            preparedStatement.setString(4, student.getMssv());

            int result = preparedStatement.executeUpdate();
            System.out.printf("Co %d dong thay doi \n", result);

            // Bước 4:
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Update failure!");
        }
    }

    @Override
    public void deletete(Student student) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            sql = "DELETE from tblStudent" +
                    " WHERE mssv=?";

            // Bước 3: tạo ra đối tượng PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, student.getMssv());

            int result = preparedStatement.executeUpdate();
            System.out.printf("Co %d dong bi xoa \n", result);

            // Bước 4:
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Delete failure");
        }
    }

    @Override
    public ArrayList<Student> selectAll() {

        ArrayList<Student> listStudent = new ArrayList<>();

        try {
            // Bước 1: tạo kết nối đến CSDL
            connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            sql = "SELECT * FROM tblStudent ";

            // Bước 3: tạo ra đối tượng PreparedStatement
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String mssv = rs.getString("mssv");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Double diemTrungBinh = rs.getDouble("diemTrungBinh");
                Student student = new Student(mssv, name, age, diemTrungBinh);
                listStudent.add(student);
            }

            System.out.println("Select all success!!!");

            // Bước 4
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Select all failure");
        }
        return listStudent;
    }

}
