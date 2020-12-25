package lk.usj.OPD_Management.java.service.custom.impl;

import lk.usj.OPD_Management.java.dao.DAOFactory;
import lk.usj.OPD_Management.java.dao.custom.PostalDAO;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.entity.Postal;
import lk.usj.OPD_Management.java.service.custom.PostalBO;

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
}
