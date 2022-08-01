package jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.database.JDBCUtil;
import jdbc.model.Student;

public class StudentDAO implements DAOInterface<Student> {



    @Override
    public void insert(Student t) {
        
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            String sql = "INSERT INTO tblStudent (mssv, name, age, diemTrungBinh) " +
            " VALUES (?, ?, ?, ?)";
            
            
            // Bước 3: tạo ra đối tượng PreparedStatement 
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getMssv());
            preparedStatement.setString(2, t.getName());
            preparedStatement.setInt(3, t.getAge());
            preparedStatement.setDouble(4, t.getDiemTrungBinh());
            preparedStatement.executeUpdate();

            // Bước 4:
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Trung mssv");
        }

    }

    @Override
    public void update(Student t) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            String sql = "UPDATE tblStudent " +
                        "SET name=?, age=?, diemTrungBinh=?" +
                        " WHERE mssv=?";

            // Bước 3: tạo ra đối tượng PreparedStatement 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getName());
            preparedStatement.setInt(2, t.getAge());
            preparedStatement.setDouble(3, t.getDiemTrungBinh());
            preparedStatement.setString(4, t.getMssv());

            preparedStatement.executeUpdate();
            
            // Bước 4:
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Khong tim thay mssv");
        }
    }

    @Override
    public void deletete(Student t) {
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            String sql = "DELETE from tblStudent" +
                    " WHERE mssv=?";

            // Bước 3: tạo ra đối tượng PreparedStatement 
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getMssv());        
            preparedStatement.executeUpdate();

            // Bước 4:
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Student> selectAll() {

        ArrayList<Student> listStudent = new ArrayList<>();
        
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: thực thi câu lệnh SQL
            String sql = "SELECT * FROM tblStudent ";

            // Bước 3: tạo ra đối tượng PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                String mssv = rs.getString("mssv");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Double diemTrungBinh = rs.getDouble("diemTrungBinh");
                Student student = new Student(mssv, name, age, diemTrungBinh);
                listStudent.add(student);
            }

            //Bước 4
            JDBCUtil.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listStudent;
    }

}
