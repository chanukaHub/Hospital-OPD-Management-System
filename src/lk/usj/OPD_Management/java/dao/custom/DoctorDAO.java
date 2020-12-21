package lk.usj.OPD_Management.java.dao.custom;

import lk.usj.OPD_Management.java.dao.CrudDAO;
import lk.usj.OPD_Management.java.entity.Doctor;

import java.util.ArrayList;

public interface DoctorDAO extends CrudDAO<Doctor,String> {
    int getLastDoctorID() throws Exception;

    ArrayList<Doctor> getAllDoctorsUsingSpecialistArea(String specialistArea) throws Exception;
}
