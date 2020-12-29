package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.*;
import lk.usj.OPD_Management.java.dao.custom.Impl.AdminDAOImpl;
import lk.usj.OPD_Management.java.dto.*;
import lk.usj.OPD_Management.java.entity.*;
import lk.usj.OPD_Management.java.service.custom.LoginBO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class LoginBOImpl implements LoginBO {
    private AdminDAO adminDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);
    private ReceptionistDAO receptionistDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTIONIST);
    private PatientDAO patientDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PATIENT);
    private DoctorDAO doctorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DOCTOR);
    private LoginDAO loginDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.LOGIN);

    public LoginBOImpl() {
    }


    @Override
    public boolean isValidAdminPassword(AdminDTO adminDTO) throws Exception {
        Admin searchAdmin = adminDAO.search(adminDTO.getUsername());
        if (searchAdmin == null)
            return false;
        else{
            if(searchAdmin.getPassword().equals(adminDTO.getPassword())){
                Date date= new Date();
                String type="Admin";
                loginDAO.save(new Login(
                   searchAdmin.getUsername(),
                   searchAdmin.getName(),
                   date,
                   type
                ));
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
                Date date= new Date();
                String type="Receptionist";
                loginDAO.save(new Login(
                        searchReceptionist.getUsername(),
                        searchReceptionist.getName(),
                        date,
                        type
                ));
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
                Date date= new Date();
                String type="Patient";
                loginDAO.save(new Login(
                        searchPatient.getUsername(),
                        searchPatient.getName(),
                        date,
                        type
                ));
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
                Date date= new Date();
                String type="Doctor";
                loginDAO.save(new Login(
                        searchDoctor.getUsername(),
                        searchDoctor.getName(),
                        date,
                        type
                ));
                return true;
            }else{
                return false;
            }
        }
    }

    @Override
    public ArrayList<LoginDTO> getLatestLoginUserList() throws Exception {
        ArrayList<Login> allLogins = loginDAO.getAll();
        ArrayList<LoginDTO> logins = new ArrayList<>();
        for (Login login : allLogins) {
            logins.add(new LoginDTO(
                    login.getUserName(),
                    login.getName(),
                    login.getLoginDateTime(),
                    login.getUserType()
            ));

        }
        Collections.reverse(logins);

        return logins;
    }

    @Override
    public ArrayList<LoginDTO> getAppointmentUsingDateRange(Date fromDate, Date toDate) throws Exception {
        ArrayList<Login> allLogins = loginDAO.getAll();
        ArrayList<LoginDTO> logins = new ArrayList<>();
        for (Login login : allLogins) {
            if (login.getLoginDateTime().after(fromDate) && login.getLoginDateTime().before(toDate)){
                logins.add(new LoginDTO(
                        login.getUserName(),
                        login.getName(),
                        login.getLoginDateTime(),
                        login.getUserType()
                ));
            }

        }
        return logins;
    }
}
