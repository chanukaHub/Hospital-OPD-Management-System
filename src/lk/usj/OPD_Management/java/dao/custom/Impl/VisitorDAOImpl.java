package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Visitor;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class VisitorDAOImpl implements VisitorDAO {
    @Override
    public boolean save(Visitor var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getDate());

        String wantedLine = var1.getVisitorId()+"#"+var1.getVisitorName()+"#"+var1.getPurpose()+"#"+var1.getTelNo().toString()+"#"+var1.getNicNo()+"#"+strDate+"#"+
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
        try{
            String visitorId,visitorName,purpose,phoneNumber,nicNo,date,inTime,outTime,attachment,note;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Visitor.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Visitor> visitors = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                visitorId=details[0];
                visitorName=details[1];
                purpose=details[2];
                phoneNumber=details[3];
                nicNo=details[4];
                date=details[5];
                inTime=details[6];
                outTime=details[7];
                attachment=details[8];
                note=details[9];

                try {
                    String[] dateArray = date.split("/");
                    Date date1 = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                    LocalTime localInTime= LocalTime.parse(inTime);
                    LocalTime localOutTime= LocalTime.parse(outTime);
                    Visitor visitor= new Visitor(visitorId, visitorName, purpose, Integer.parseInt(phoneNumber), nicNo,date1, localInTime, localOutTime, attachment,note);
                    visitors.add(visitor);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return visitors;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getLastVisitorID() throws Exception {
        try{
            String visitorId;
            File file = new File("Visitor.txt");
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
                visitorId=details[0];
                return Integer.parseInt(visitorId.substring(4));
            }



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }
}
