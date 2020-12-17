package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

public interface PostalBO extends SuperBO {
    boolean addPostal(PostalDTO postalDTO)throws Exception;
}
