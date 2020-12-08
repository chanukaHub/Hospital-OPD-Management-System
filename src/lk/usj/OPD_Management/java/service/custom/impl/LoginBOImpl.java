package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.AdminDAO;
import lk.usj.OPD_Management.java.dao.custom.Impl.AdminDAOImpl;
import lk.usj.OPD_Management.java.dto.AdminDTO;
import lk.usj.OPD_Management.java.dto.UserDTO;
import lk.usj.OPD_Management.java.entity.Admin;
import lk.usj.OPD_Management.java.entity.User;
import lk.usj.OPD_Management.java.service.custom.LoginBO;

public class LoginBOImpl implements LoginBO {
    private AdminDAO adminDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);

    public LoginBOImpl() {
    }


    @Override
    public boolean isValidPassword(AdminDTO user) throws Exception {
        Admin searchAdmin = adminDAO.search(user.getUsername());
        if (searchAdmin == null)
            return false;
        else{
            if(searchAdmin.getPassword().equals(user.getPassword())){
                return true;
            }else{
                return false;
            }
        }


    }
}
