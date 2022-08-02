package jdbc.dao;

import java.util.ArrayList;

public interface DAOInterface<T> {
    
    public void insert(T t);

    public void update(T t);

    public void deletete(T t);

    public ArrayList<T> selectAll();
    

    
}
