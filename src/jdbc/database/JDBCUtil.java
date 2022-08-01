package jdbc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    
    public static Connection getConnection(String databaseName) {
        
        Connection connection = null;
        
        // "jdbc:sqlserver://hostname:port;databaseName";
        String url = "jdbc:sqlserver://localhost:1433;databaseName="+databaseName+";encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
        String user = "sa";
        String password = "123";

        try {
            connection = DriverManager.getConnection(url, user, password); 
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Ket noi that bai");
        }



        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
