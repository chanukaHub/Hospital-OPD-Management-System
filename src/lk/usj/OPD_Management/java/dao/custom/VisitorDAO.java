package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Visitor;

public interface VisitorDAO extends CrudDAO<Visitor,String> {
    int getLastVisitorID() throws Exception;
}
