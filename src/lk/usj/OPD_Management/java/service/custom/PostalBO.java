package lk.usj.OPD_Management.java.service.custom;

import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.service.SuperBO;

import java.util.ArrayList;

public interface PostalBO extends SuperBO {
    boolean addPostal(PostalDTO postalDTO)throws Exception;

    ArrayList<PostalDTO> getReceivedPostalList() throws Exception;

    ArrayList<PostalDTO> getDispatchedPostalList() throws Exception;

    boolean updatePostal(PostalDTO postalDTO)throws Exception;

    boolean deleteDoctor(String text) throws Exception;

    ArrayList<PostalDTO> getPostalList() throws Exception;
}
