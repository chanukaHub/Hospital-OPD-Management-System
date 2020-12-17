package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Doctor;

public interface DoctorDAO extends CrudDAO<Doctor,String> {
    int getLastDoctorID() throws Exception;
}
