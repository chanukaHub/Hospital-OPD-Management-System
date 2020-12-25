package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.PostalDAO;
import lk.usj.OPD_Management.java.entity.Postal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PostalIDAOImpl implements PostalDAO {
    @Override
    public boolean save(Postal var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getPostalDate());

        String wantedLine = var1.getReferenceNumber()+"#"+var1.getFromAddress()+"#"+var1.getToAddress().toString()+"#"+var1.getFromName()+"#"+var1.getToName()+"#"+strDate+"#"+
                var1.getAttachment()+"#"+var1.getNotes()+"#"+var1.getType();
        File file = new File("Postal.txt");
        if (!file.exists()) {//checking the is given file exists

            file.createNewFile();//creating new file
            Exception fileError =new IOException("File is not founded");
            System.out.println(fileError);
        }
        FileWriter fw = new FileWriter(file,true);

        BufferedWriter bw = new BufferedWriter(fw);

        try {
            bw.write(wantedLine);
            bw.newLine();
            bw.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Postal var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Postal search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Postal> getAll() throws Exception {
        return null;
    }
}
