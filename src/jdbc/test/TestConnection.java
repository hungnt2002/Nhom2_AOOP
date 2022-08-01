package jdbc.test;

import java.sql.Connection;

import jdbc.database.JDBCUtil;

public class TestConnection {
    
    public static void main(String[] args) {
        
        

        Connection connection = JDBCUtil.getConnection("DemoJDBC");

        if(connection != null){

            System.out.println(connection);
            System.out.println("Ket noi thanh cong!");
        }

        
        

        //Student student = new Student("2004110025", "Nguyen Van D", 22, 7.8 );
        //StudentDAO.getInstance().insert(student); // Thêm dữ liệu vào csdl
        //StudentDAO.getInstance().deletete(student);

        //StudentDAO.getInstance().update(student); // Sửa dữ liệu trong csdl

        // ArrayList<Student> listStudent = new ArrayList<>();
        // listStudent = StudentDAO.getInstance().selectAll();

        // for (Student stu : listStudent) {
        //    System.out.println(stu.toString());
        // }
        
    }
}
