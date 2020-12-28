package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.ComplaintDAO;
import lk.usj.OPD_Management.java.entity.Complaint;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class ComplaintDAOImpl implements ComplaintDAO {
    @Override
    public boolean save(Complaint var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getDate());

        String wantedLine = var1.getComplaintId()+"#"+var1.getType()+"#"+var1.getComplaintBy()+"#"+var1.getPhoneNumber()+"#"+strDate+"#"+
                var1.getDescription()+"#"+var1.getActionTaken()+"#"+var1.getNote()+"#"+var1.getAttachDocument()+var1.getStatus();
        File file = new File("Complaint.txt");
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
    public boolean update(Complaint var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Complaint search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Complaint> getAll() throws Exception {
        return null;
    }

    @Override
    public int getLastVisitorID() throws Exception {
        try{
            String complaintId;
            File file = new File("Complaint.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            String last = null;

            while(scanner.hasNextLine()){
                last=scanner.nextLine();
            }
            if (last == null){
                return 0;
            }else {
                String[] details = last.split("#");
                complaintId=details[0];
                return Integer.parseInt(complaintId.substring(4));
            }



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }
}
