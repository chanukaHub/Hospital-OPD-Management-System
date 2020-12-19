package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.PatientDAO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Receptionist;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public boolean save(Patient var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getDateOfBirth());

        String wantedLine = var1.getUsername()+"#"+var1.getName()+"#"+var1.getGender()+"#"+var1.getPhoneNumber()+"#"+var1.getIdCard()+"#"+
                strDate+"#"+var1.getAddress()+"#"+var1.getMaritalStatus()+"#"+var1.getPassword()+"#"+var1.getBloodGroup()+"#"+
                var1.getAllergies()+"#"+var1.getNote();
        File file = new File("Patient.txt");
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
    public boolean update(Patient var1) throws Exception {
        try{
            String username, name, gender, phoneNumber, idCard,dateOfBirth, address, maritalStatus, password;
            String bloodGroup,allergies,note;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Patient.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Patient> patients = new ArrayList<>();

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
                bloodGroup=details[9];
                allergies=details[10];
                note=details[11];


                try {
                    String[] dateArray = dateOfBirth.split("/");
                    Date birthDate = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                    Patient patient= new Patient(username, name, gender, phoneNumber, idCard,birthDate, address, maritalStatus, password,bloodGroup,allergies,note);
                    patients.add(patient);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }



            for (Patient p:patients){
                if(p.getUsername().equals(var1.getUsername())){
                    p.setUsername(var1.getUsername());
                    p.setName(var1.getName());
                    p.setGender(var1.getGender());
                    p.setPhoneNumber(var1.getPhoneNumber());
                    p.setIdCard(var1.getIdCard());
                    p.setDateOfBirth(var1.getDateOfBirth());
                    p.setAddress(var1.getAddress());
                    p.setMaritalStatus(var1.getMaritalStatus());
                    p.setPassword(var1.getBloodGroup());
                    p.setBloodGroup(var1.getBloodGroup());
                    p.setAllergies(var1.getAllergies());
                    p.setNote(var1.getNote());
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


                for (Patient p:patients){
                    String strDate = format.format(p.getDateOfBirth());
                    String wantedLine = p.getUsername()+"#"+p.getName()+"#"+p.getGender()+"#"+p.getPhoneNumber()+"#"+p.getIdCard()+"#"+
                            strDate+"#"+p.getAddress()+"#"+p.getMaritalStatus()+"#"+p.getPassword()+"#"+p.getBloodGroup()+"#"+
                            p.getAllergies()+"#"+p.getNote();
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
    public Patient search(String var1) throws Exception {
        try{
            String username, name, gender, phoneNumber, idCard,dateOfBirth, address, maritalStatus, password;
            String bloodGroup,allergies,note;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Patient.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            List<Patient> patients = new ArrayList<>();

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
                bloodGroup=details[9];
                allergies=details[10];
                note=details[11];


                try {
                    String[] dateArray = dateOfBirth.split("/");
                    Date birthDate = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                    Patient patient= new Patient(username, name, gender, phoneNumber, idCard,birthDate, address, maritalStatus, password,bloodGroup,allergies,note);
                    patients.add(patient);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            for (Patient p:patients){
                if(p.getUsername().equals(var1)){
                    return p;
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Patient> getAll() throws Exception {
        try{
            String username;
            String name;
            String gender;
            String phoneNumber;
            String idCard;
            String dateOfBirth;
            String address;
            String maritalStatus;
            String password;
            String bloodGroup,allergies,note;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Patient.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Patient> patients = new ArrayList<>();

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
                bloodGroup=details[9];
                allergies=details[10];
                note=details[11];


                try {
                    String[] dateArray = dateOfBirth.split("/");
                    Date birthDate = new GregorianCalendar(Integer.parseInt(dateArray[2]), Integer.parseInt(dateArray[1]) - 1, Integer.parseInt(dateArray[0])).getTime();
                    Patient patient= new Patient(username, name, gender, phoneNumber, idCard,birthDate, address, maritalStatus, password,bloodGroup,allergies,note);
                    patients.add(patient);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            return patients;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
