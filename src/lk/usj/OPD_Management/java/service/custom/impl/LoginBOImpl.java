package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.AdminDAO;
import lk.usj.OPD_Management.java.dao.custom.Impl.AdminDAOImpl;
import lk.usj.OPD_Management.java.dao.custom.ReceptionistDAO;
import lk.usj.OPD_Management.java.dto.AdminDTO;
import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.dto.UserDTO;
import lk.usj.OPD_Management.java.entity.Admin;
import lk.usj.OPD_Management.java.entity.Receptionist;
import lk.usj.OPD_Management.java.entity.User;
import lk.usj.OPD_Management.java.service.custom.LoginBO;

public class LoginBOImpl implements LoginBO {
    private AdminDAO adminDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);
    private ReceptionistDAO receptionistDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECEPTIONIST);

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
}
