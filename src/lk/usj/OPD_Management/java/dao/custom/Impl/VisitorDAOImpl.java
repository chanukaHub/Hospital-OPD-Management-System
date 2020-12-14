package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.entity.Visitor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitorDAOImpl implements VisitorDAO {
    @Override
    public boolean save(Visitor var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getDate());

        String wantedLine = var1.getVisitorName()+"#"+var1.getPurpose()+"#"+var1.getTelNo().toString()+"#"+var1.getNicNo()+"#"+strDate+"#"+
                var1.getInTime().toString()+"#"+var1.getOutTime().toString()+"#"+var1.getAttachment()+"#"+var1.getNotes();
        File file = new File("Visitor.txt");
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
    public boolean update(Visitor var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Visitor search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Visitor> getAll() throws Exception {
        return null;
    }
}
