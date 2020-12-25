package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Postal;

import java.util.ArrayList;

public interface PostalDAO extends CrudDAO<Postal,String> {
    ArrayList<Postal> getAllPostalUsingType(String type)throws Exception;
}
