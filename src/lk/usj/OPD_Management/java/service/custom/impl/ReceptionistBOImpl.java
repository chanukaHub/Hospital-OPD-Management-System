package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.ReceptionistDAO;
import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Receptionist;
import lk.usj.OPD_Management.java.service.custom.ReceptionistBO;

import java.util.ArrayList;

public class ReceptionistBOImpl implements ReceptionistBO {
    private ReceptionistDAO receptionistDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTIONIST);
    @Override
    public int getNextReceptionistID() throws Exception {
        return (receptionistDAO.getLastReceptionistID()+1);
    }

    @Override
    public boolean addReceptionist(ReceptionistDTO receptionistDTO) throws Exception {
        return receptionistDAO.save(new Receptionist(
                receptionistDTO.getUsername(),
                receptionistDTO.getName(),
                receptionistDTO.getGender(),
                receptionistDTO.getPhoneNumber(),
                receptionistDTO.getIdCard(),
                receptionistDTO.getDateOfBirth(),
                receptionistDTO.getAddress(),
                receptionistDTO.getMaritalStatus(),
                receptionistDTO.getPassword(),
                receptionistDTO.getStaffID(),
                receptionistDTO.getStaffEmail(),
                receptionistDTO.getDateOfJoin(),
                receptionistDTO.getPhotograph(),
                receptionistDTO.getDocument(),
                receptionistDTO.getNote()
        ));
    }

    @Override
    public ArrayList<ReceptionistDTO> getAllReceptionist() throws Exception{
        ArrayList<Receptionist> allReceptionists = receptionistDAO.getAll();
        ArrayList<ReceptionistDTO> receptionists = new ArrayList<>();
        for (Receptionist receptionist : allReceptionists) {
            receptionists.add(new ReceptionistDTO(
                    receptionist.getUsername(),
                    receptionist.getName(),
                    receptionist.getGender(),
                    receptionist.getPhoneNumber(),
                    receptionist.getIdCard(),
                    receptionist.getDateOfBirth(),
                    receptionist.getAddress(),
                    receptionist.getMaritalStatus(),
                    receptionist.getPassword(),
                    receptionist.getStaffID(),
                    receptionist.getStaffEmail(),
                    receptionist.getDateOfJoin(),
                    receptionist.getPhotograph(),
                    receptionist.getDocument(),
                    receptionist.getNote()
            ));

        }
        return receptionists;
    }

    @Override
    public boolean updateDoctor(ReceptionistDTO receptionistDTO) throws Exception {
        return receptionistDAO.update(new Receptionist(
                receptionistDTO.getUsername(),
                receptionistDTO.getName(),
                receptionistDTO.getGender(),
                receptionistDTO.getPhoneNumber(),
                receptionistDTO.getIdCard(),
                receptionistDTO.getDateOfBirth(),
                receptionistDTO.getAddress(),
                receptionistDTO.getMaritalStatus(),
                receptionistDTO.getPassword(),
                receptionistDTO.getStaffID(),
                receptionistDTO.getStaffEmail(),
                receptionistDTO.getDateOfJoin(),
                receptionistDTO.getPhotograph(),
                receptionistDTO.getDocument(),
                receptionistDTO.getNote()
        ));
    }
}