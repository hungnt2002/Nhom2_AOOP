package jdbc;
import java.util.Scanner;
import jdbc.model.Menu;

public class BootStrap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int select;

        do{
                
            Menu.showMenu();
            System.out.print("Chon chuc nang: ");
            select = sc.nextInt();
            System.out.println("==================================");      
            Menu.menu(select);
            
        }while(select !=0);
    }

}
