package lk.usj.OPD_Management.java.dao;

import java.util.ArrayList;

public interface CrudDAO<T,ID> extends SuperDAO{
    boolean save(T var1) throws Exception;

    boolean update(T var1) throws Exception;

    boolean delete(ID var1) throws Exception;

    T search(ID var1) throws Exception;

    ArrayList<T> getAll() throws Exception;
}
