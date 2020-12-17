package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.DoctorDAO;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Receptionist;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DoctorDAOImpl implements DoctorDAO {
    @Override
    public boolean save(Doctor var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getDateOfBirth());
        String joinDate = format.format(var1.getDateOfJoin());

        String wantedLine = var1.getUsername()+"#"+var1.getName()+"#"+var1.getGender()+"#"+var1.getPhoneNumber()+"#"+var1.getIdCard()+"#"+
                strDate+"#"+var1.getAddress()+"#"+var1.getMaritalStatus()+"#"+var1.getPassword()+"#"+var1.getStaffID()+"#"+
                var1.getStaffEmail()+"#"+joinDate+"#"+var1.getPhotograph()+"#"+var1.getDocument()+"#"+var1.getNote()+"#"+var1.getSpecialistArea();
        File file = new File("Doctor.txt");
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
    public boolean update(Doctor var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Doctor search(String var1) throws Exception {
        try{
            String username, name, gender, phoneNumber, idCard,dateOfBirth, address, maritalStatus, password;
            String staffId;
            String staffEmail;
            String dateOfJoin;
            String photograph;
            String document;
            String note;
            String specialistArea;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Doctor.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            List<Doctor> doctors = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                username=details[0];
                name=details[1];
                gender=details[2];
                phoneNumber=details[3];
                idCard=details[4];
                dateOfBirth=details[5];
                address=details[6];
                maritalStatus=details[7];
                password=details[8];
                staffId=details[9];
                staffEmail=details[10];
                dateOfJoin=details[11];
                photograph=details[12];
                document=details[13];
                note =details[14];
                specialistArea =details[15];

                try {
                    Date birthDate =format.parse(dateOfBirth);
                    Date joinDate =format.parse(dateOfJoin);
                    Doctor doctor= new Doctor(username, name, gender, phoneNumber, idCard,birthDate, address, maritalStatus, password,staffId,staffEmail,joinDate,photograph,document,note,specialistArea);
                    doctors.add(doctor);
                }catch (ParseException e){
                    e.printStackTrace();
                }
            }
            for (Doctor d:doctors){
                if(d.getUsername().equals(var1)){
                    return d;
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Doctor> getAll() throws Exception {
        try{
            String username, name, gender, phoneNumber, idCard,dateOfBirth, address, maritalStatus, password;
            String staffId;
            String staffEmail;
            String dateOfJoin;
            String photograph;
            String document;
            String note;
            String specialistArea;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Doctor.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Doctor> doctors = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                username=details[0];
                name=details[1];
                gender=details[2];
                phoneNumber=details[3];
                idCard=details[4];
                dateOfBirth=details[5];
                address=details[6];
                maritalStatus=details[7];
                password=details[8];
                staffId=details[9];
                staffEmail=details[10];
                dateOfJoin=details[11];
                photograph=details[12];
                document=details[13];
                note =details[14];
                specialistArea =details[15];


                try {
                    Date birthDate =format.parse(dateOfBirth);
                    Date joinDate =format.parse(dateOfJoin);
                    Doctor doctor= new Doctor(username, name, gender, phoneNumber, idCard,birthDate, address, maritalStatus, password,staffId,staffEmail,joinDate,photograph,document,note,specialistArea);
                    doctors.add(doctor);
                }catch (ParseException e){
                    e.printStackTrace();
                }
            }
            return doctors;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getLastDoctorID() throws Exception{
        try{
            String staffId;
            File file = new File("Doctor.txt");
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
            String[] details = last.split("#");
            staffId=details[9];
            return Integer.parseInt(staffId.substring(4));


        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }
}
