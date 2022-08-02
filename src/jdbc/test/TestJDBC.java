package jdbc.test;

import java.util.ArrayList;

import jdbc.dao.preparestatement.StudentDAO;
import jdbc.model.Student;

public class TestJDBC {
    
    public static void main(String[] args) {
        
        Student student = new Student("2004110040", "Nguyễn Văn K", 20, 6.7);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.insert(student);
        
    }

}
