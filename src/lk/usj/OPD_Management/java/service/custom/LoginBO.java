package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.AdminDTO;
import lk.usj.OPD_Management.java.dto.UserDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

public interface LoginBO extends SuperBO {
    boolean isValidPassword(AdminDTO user) throws Exception;
}
