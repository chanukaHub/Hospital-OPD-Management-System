package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.ReceptionistDAO;
import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Receptionist;
import lk.usj.OPD_Management.java.service.custom.ReceptionistBO;

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
}