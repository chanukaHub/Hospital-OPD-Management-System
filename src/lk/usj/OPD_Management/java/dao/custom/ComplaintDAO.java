package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Complaint;

public interface ComplaintDAO extends CrudDAO<Complaint,String> {
    int getLastVisitorID() throws Exception;

    int countNewComplaints() throws Exception;
}
