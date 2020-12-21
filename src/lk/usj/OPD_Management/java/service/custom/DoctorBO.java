package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.util.ArrayList;

public interface DoctorBO extends SuperBO {
    

    int getNextDoctorID() throws Exception;

    boolean addDoctor(DoctorDTO doctorDTO)throws Exception;

    ArrayList<DoctorDTO> getAllDoctors()throws Exception;

    boolean updateDoctor(DoctorDTO doctorDTO)throws Exception;

    boolean deleteDoctor(String text)throws Exception;

    ArrayList<DoctorDTO> getAllDoctorsUsingSpecialistArea(String specialistArea) throws Exception;
}
