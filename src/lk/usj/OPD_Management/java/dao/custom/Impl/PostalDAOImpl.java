package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.PostalDAO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Postal;
import lk.usj.OPD_Management.java.entity.Receptionist;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class PostalDAOImpl implements PostalDAO {
    @Override
    public boolean save(Postal var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getPostalDate());

        String wantedLine = var1.getReferenceNumber()+"#"+var1.getFromAddress()+"#"+var1.getToAddress()+"#"+var1.getFromName()+"#"+var1.getToName()+"#"+strDate+"#"+
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
        try{
            String referenceNo, fromAddress, toAddress, fromName, toName,date, attachment, notes, postalType;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Postal.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Postal> postals = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                referenceNo=details[0];
                fromAddress=details[1];
                toAddress=details[2];
                fromName=details[3];
                toName=details[4];
                date=details[5];
                attachment=details[6];
                notes=details[7];
                postalType=details[8];



                String[] dateArray = date.split("/");
                Date postalDate = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                Postal postal = new Postal(referenceNo, fromAddress, toAddress, fromName, toName, postalDate, attachment, notes, postalType);
                postals.add(postal);
            }

            for (Postal p:postals){
                if(p.getReferenceNumber().equals(var1.getReferenceNumber())){
                    p.setFromAddress(var1.getFromAddress());
                    p.setToAddress(var1.getToAddress());
                    p.setFromName(var1.getFromName());
                    p.setToName(var1.getToName());
                    p.setPostalDate(var1.getPostalDate());
                    p.setAttachment(var1.getAttachment());
                    p.setNotes(var1.getNotes());
                }
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);


            for (Postal p:postals){
                String strDate = format.format(p.getPostalDate());
                String wantedLine = p.getReferenceNumber()+"#"+p.getFromAddress()+"#"+p.getToAddress()+"#"+p.getFromName()+"#"+p.getToName()+"#"+strDate+"#"+
                        p.getAttachment()+"#"+p.getNotes()+"#"+p.getType();

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
        try{
            String referenceNo, fromAddress, toAddress, fromName, toName,date, attachment, notes, postalType;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Postal.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Postal> postals = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                referenceNo=details[0];
                fromAddress=details[1];
                toAddress=details[2];
                fromName=details[3];
                toName=details[4];
                date=details[5];
                attachment=details[6];
                notes=details[7];
                postalType=details[8];



                String[] dateArray = date.split("/");
                Date postalDate = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                Postal postal = new Postal(referenceNo, fromAddress, toAddress, fromName, toName, postalDate, attachment, notes, postalType);
                postals.add(postal);
            }

            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }

            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(fw);


            for (Postal p:postals){
                if (p.getReferenceNumber().equals(var1)){
                    continue;
                }else {
                    String strDate = format.format(p.getPostalDate());
                    String wantedLine = p.getReferenceNumber()+"#"+p.getFromAddress()+"#"+p.getToAddress()+"#"+p.getFromName()+"#"+p.getToName()+"#"+strDate+"#"+
                            p.getAttachment()+"#"+p.getNotes()+"#"+p.getType();

                    bw.write(wantedLine);
                    bw.newLine();
                }

            }

            bw.close();
            return true;



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Postal search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Postal> getAll() throws Exception {
        try{
            String referenceNo, fromAddress, toAddress, fromName, toName,date, attachment, notes, postalType;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Postal.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Postal> postals = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                referenceNo=details[0];
                fromAddress=details[1];
                toAddress=details[2];
                fromName=details[3];
                toName=details[4];
                date=details[5];
                attachment=details[6];
                notes=details[7];
                postalType=details[8];


                String[] dateArray = date.split("/");
                Date postalDate = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                Postal postal = new Postal(referenceNo, fromAddress, toAddress, fromName, toName, postalDate, attachment, notes, postalType);
                postals.add(postal);


            }
            return postals;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Postal> getAllPostalUsingType(String type) throws Exception {
        try{
            String referenceNo, fromAddress, toAddress, fromName, toName,date, attachment, notes, postalType;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Postal.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Postal> postals = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                referenceNo=details[0];
                fromAddress=details[1];
                toAddress=details[2];
                fromName=details[3];
                toName=details[4];
                date=details[5];
                attachment=details[6];
                notes=details[7];
                postalType=details[8];


                if (postalType.equals(type)) {
                    String[] dateArray = date.split("/");
                    Date postalDate = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                    Postal postal = new Postal(referenceNo, fromAddress, toAddress, fromName, toName, postalDate, attachment, notes, postalType);
                    postals.add(postal);
                }

            }
            return postals;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
