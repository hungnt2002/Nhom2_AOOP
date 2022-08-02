package jdbc.dao.statement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jdbc.dao.DAOInterface;
import jdbc.database.JDBCUtil;
import jdbc.model.Student;

public class StudentDAO implements DAOInterface<Student> {

    private Connection connection;
    private String sql;
    private Statement statement;

    @Override
    public void insert(Student student) {
        
        try {
            // Bước 1: tạo kết nối đến CSDL
            connection = JDBCUtil.getConnection("DemoJDBC");

            // Bước 2: Tạo đối tượng statement
            statement = connection.createStatement();

            // Bước 3: thực thi câu lệnh SQL
            // "INSERT INTO <tên bảng> (thuộc tính, ...) " + " VALUES ('"String"', "'String'", 'int', 'double');
            sql = "INSERT INTO tblStudent (mssv, name, age, diemTrungBinh) " +
                    " VALUES ('"+student.getMssv()+"', '"+student.getName()+"', "+student.getAge()+", "+student.getDiemTrungBinh()+")";


            int result = statement.executeUpdate(sql);
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void deletete(Student student) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<Student> selectAll() {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
