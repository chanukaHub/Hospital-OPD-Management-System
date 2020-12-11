package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.PatientDAO;
import lk.usj.OPD_Management.java.entity.Patient;
import lk.usj.OPD_Management.java.entity.Receptionist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public boolean save(Patient var1) throws Exception {
        return false;
    }

    @Override
    public boolean update(Patient var1) throws Exception {
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
                    Date birthDate =format.parse(dateOfBirth);
                    Patient patient= new Patient(username, name, gender, phoneNumber, idCard,birthDate, address, maritalStatus, password,bloodGroup,allergies,note);
                    patients.add(patient);
                }catch (ParseException e){
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
        return null;
    }
}
