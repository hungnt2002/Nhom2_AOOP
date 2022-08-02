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

        JDBCUtil.closeConnection(connection);

        
    }
}
