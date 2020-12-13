package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.AdminDAO;
import lk.usj.OPD_Management.java.dao.custom.DoctorDAO;
import lk.usj.OPD_Management.java.dao.custom.Impl.AdminDAOImpl;
import lk.usj.OPD_Management.java.dao.custom.PatientDAO;
import lk.usj.OPD_Management.java.dao.custom.ReceptionistDAO;
import lk.usj.OPD_Management.java.dto.*;
import lk.usj.OPD_Management.java.entity.*;
import lk.usj.OPD_Management.java.service.custom.LoginBO;

public class LoginBOImpl implements LoginBO {
    private AdminDAO adminDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);
    private ReceptionistDAO receptionistDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTIONIST);
    private PatientDAO patientDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PATIENT);
    private DoctorDAO doctorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DOCTOR);

    public LoginBOImpl() {
    }


    @Override
    public boolean isValidAdminPassword(AdminDTO adminDTO) throws Exception {
        Admin searchAdmin = adminDAO.search(adminDTO.getUsername());
        if (searchAdmin == null)
            return false;
        else{
            if(searchAdmin.getPassword().equals(adminDTO.getPassword())){
                return true;
            }else{
                return false;
            }
        }


    }

    @Override
    public boolean isValidReceptionistPassword(ReceptionistDTO receptionistDTO) throws Exception{
        Receptionist searchReceptionist = receptionistDAO.search(receptionistDTO.getUsername());
        if (searchReceptionist == null)
            return false;
        else{
            if(searchReceptionist.getPassword().equals(receptionistDTO.getPassword())){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean isValidPatientPassword(PatientDTO patientDTO) throws Exception {
        Patient searchPatient = patientDAO.search(patientDTO.getUsername());
        if (searchPatient == null)
            return false;
        else{
            if(searchPatient.getPassword().equals(patientDTO.getPassword())){
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public boolean isValidDoctorPassword(DoctorDTO doctorDTO) throws Exception {
        Doctor searchDoctor = doctorDAO.search(doctorDTO.getUsername());
        if (searchDoctor == null)
            return false;
        else{
            if(searchDoctor.getPassword().equals(doctorDTO.getPassword())){
                return true;
            }else{
                return false;
            }
        }
    }
}
