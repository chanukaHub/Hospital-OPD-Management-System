package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.PostalDAO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Postal;
import lk.usj.OPD_Management.java.service.custom.PostalBO;

import java.util.ArrayList;

public class PostalBOImpl implements PostalBO {
    private PostalDAO postalDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.POSTAL);

    public PostalBOImpl() {
    }

    @Override
    public boolean addPostal(PostalDTO postalDTO) throws Exception {
        return postalDAO.save(new Postal(
                postalDTO.getReferenceNumber(),
                postalDTO.getFromAddress(),
                postalDTO.getToAddress(),
                postalDTO.getFromName(),
                postalDTO.getToName(),
                postalDTO.getPostalDate(),
                postalDTO.getAttachment(),
                postalDTO.getNotes(),
                postalDTO.getType()
        ));
    }

    @Override
    public ArrayList<PostalDTO> getReceivedPostalList() throws Exception {
        String type ="Received";
        ArrayList<Postal> allPostal = postalDAO.getAllPostalUsingType(type);
        ArrayList<PostalDTO> postal = new ArrayList<>();
        for (Postal postal1 : allPostal) {
            postal.add(new PostalDTO(
                    postal1.getReferenceNumber(),
                    postal1.getFromAddress(),
                    postal1.getToAddress(),
                    postal1.getFromName(),
                    postal1.getToName(),
                    postal1.getPostalDate(),
                    postal1.getAttachment(),
                    postal1.getNotes(),
                    postal1.getType()
            ));
        }
        return postal;
    }

    @Override
    public ArrayList<PostalDTO> getDispatchedPostalList() throws Exception {
        String type ="Dispatched";
        ArrayList<Postal> allPostal = postalDAO.getAllPostalUsingType(type);
        ArrayList<PostalDTO> postal = new ArrayList<>();
        for (Postal postal1 : allPostal) {
            postal.add(new PostalDTO(
                    postal1.getReferenceNumber(),
                    postal1.getFromAddress(),
                    postal1.getToAddress(),
                    postal1.getFromName(),
                    postal1.getToName(),
                    postal1.getPostalDate(),
                    postal1.getAttachment(),
                    postal1.getNotes(),
                    postal1.getType()
            ));
        }
        return postal;
    }

    @Override
    public boolean updatePostal(PostalDTO postalDTO) throws Exception {
        return postalDAO.update(new Postal(
                postalDTO.getReferenceNumber(),
                postalDTO.getFromAddress(),
                postalDTO.getToAddress(),
                postalDTO.getFromName(),
                postalDTO.getToName(),
                postalDTO.getPostalDate(),
                postalDTO.getAttachment(),
                postalDTO.getNotes(),
                postalDTO.getType()
        ));

    }

    @Override
    public boolean deleteDoctor(String text) throws Exception {
        return postalDAO.delete(text);
    }
}
