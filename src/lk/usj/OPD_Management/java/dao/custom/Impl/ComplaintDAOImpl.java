package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.ComplaintDAO;
import lk.usj.OPD_Management.java.entity.Appointment;
import lk.usj.OPD_Management.java.entity.Complaint;
import lk.usj.OPD_Management.java.entity.Receptionist;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ComplaintDAOImpl implements ComplaintDAO {
    @Override
    public boolean save(Complaint var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getDate());

        String wantedLine = var1.getComplaintId()+"#"+var1.getType()+"#"+var1.getComplaintBy()+"#"+var1.getPhoneNumber()+"#"+strDate+"#"+
                var1.getDescription()+"#"+var1.getActionTaken()+"#"+var1.getNote()+"#"+var1.getAttachDocument()+"#"+var1.getStatus();
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
        try{
            String complaintId,type,complaintBy,phoneNo,date,description,actionTaken,note,attachmentDocument,status;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Complaint.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Complaint> complaints = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                complaintId=details[0];
                type=details[1];
                complaintBy=details[2];
                phoneNo=details[3];
                date=details[4];
                description=details[5];
                actionTaken=details[6];
                note=details[7];
                attachmentDocument=details[8];
                status=details[9];



                String[] dateArray = date.split("/");
                Date date1 = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();

                Complaint complaint=new Complaint(complaintId,type,complaintBy,phoneNo,date1,description,actionTaken,note,attachmentDocument,status);
                complaints.add(complaint);

            }
            for (Complaint complaint : complaints) {
                if (complaint.getComplaintId().equals(var1.getComplaintId())) {
                    complaint.setStatus(var1.getStatus());
                    complaint.setType(var1.getType());
                    complaint.setDescription(var1.getDescription());
                    complaint.setActionTaken(var1.getActionTaken());
                    complaint.setNote(var1.getNote());
                }
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            File file1 = new File("Complaint.txt");

            if (!file1.exists()) {//checking the is given file exists

                file1.createNewFile();//creating new file
                Exception fileError = new IOException("File is not founded");
                System.out.println(fileError);
            }

            FileWriter fw = new FileWriter(file1, true);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Complaint c : complaints) {
                String strDate = format.format(c.getDate());

                String wantedLine = c.getComplaintId()+"#"+c.getType()+"#"+c.getComplaintBy()+"#"+c.getPhoneNumber()+"#"+strDate+"#"+
                        c.getDescription()+"#"+c.getActionTaken()+"#"+c.getNote()+"#"+c.getAttachDocument()+"#"+c.getStatus();

                bw.write(wantedLine);
                bw.newLine();

            }
            bw.close();
            return true;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
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
        try{
            String complaintId,type,complaintBy,phoneNo,date,description,actionTaken,note,attachmentDocument,status;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Complaint.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Complaint> complaints = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                complaintId=details[0];
                type=details[1];
                complaintBy=details[2];
                phoneNo=details[3];
                date=details[4];
                description=details[5];
                actionTaken=details[6];
                note=details[7];
                attachmentDocument=details[8];
                status=details[9];



                String[] dateArray = date.split("/");
                Date date1 = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();

                Complaint complaint=new Complaint(complaintId,type,complaintBy,phoneNo,date1,description,actionTaken,note,attachmentDocument,status);
                complaints.add(complaint);

            }
            return complaints;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
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
