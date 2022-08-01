package jdbc;

import java.sql.Connection;
import java.util.Scanner;

import jdbc.database.JDBCUtil;
import jdbc.model.Menu;

public class BootStrap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select;

        Connection connection = JDBCUtil.getConnection("DemoJDBC");

        if(connection != null){

            System.out.println(connection);
            System.out.println("Ket noi thanh cong!");
        }

        do{
                
            Menu.showMenu();
            System.out.print("Chon chuc nang: ");
            select = sc.nextInt();
            Menu.menu(select);
            
        }while(select !=0);
    }

}
