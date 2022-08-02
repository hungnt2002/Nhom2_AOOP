package jdbc.model;

import java.util.ArrayList;

import jdbc.dao.statement.StudentDAO;



public class Menu {

    
    public static void menu(int select ){

        Student student = new Student("2004110010", "Nguyen Van E", 21, 8.8 );

        StudentDAO studentDAO = new StudentDAO();

        switch(select){
            
            case 1: studentDAO.insert(student);
                break;
            case 2: studentDAO.update(student);
                break;
            case 3: studentDAO.deletete(student);
                break;
            case 4:
                ArrayList<Student> listStudent = new ArrayList<>();
                listStudent = studentDAO.selectAll();
                for (Student stu : listStudent) {
                    System.out.println(stu.toString());
                }
                break;
            default:
                System.exit(0);
            
        }
    }

    public static void showMenu() {
        System.out.println("===============Menu===============");
        System.out.println("1.Them sinh vien vao csdl");
        System.out.println("2.Sua thong tin sinh vien trong csdl");
        System.out.println("3.Xoa thong tin sinh vien trong csdl");
        System.out.println("4.In thong tin sinh vien tu csdl");
        System.out.println("0.Thoat chuong trinh");
    }
}
