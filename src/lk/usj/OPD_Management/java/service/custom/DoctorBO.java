package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

public interface DoctorBO extends SuperBO {

    int getNextDoctorID() throws Exception;

    boolean addDoctor(DoctorDTO doctorDTO)throws Exception;
}
