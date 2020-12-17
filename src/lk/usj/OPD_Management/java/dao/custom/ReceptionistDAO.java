package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Receptionist;

public interface ReceptionistDAO extends CrudDAO<Receptionist,String> {
    int getLastReceptionistID() throws Exception;
}
