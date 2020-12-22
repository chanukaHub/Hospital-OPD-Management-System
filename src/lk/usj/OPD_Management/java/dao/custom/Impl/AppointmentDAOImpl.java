package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.AppointmentDAO;
import lk.usj.OPD_Management.java.entity.Appointment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public boolean save(Appointment var1) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(var1.getAppointmentDate());

        String wantedLine = var1.getAppointmentId()+"#"+var1.getPatient().getUsername()+"#"+var1.getDoctor().getUsername()+"#"+var1.getAppointmentNo()+"#"+strDate+"#"+
                "#"+var1.getAppointmentTime()+"#"+var1.getSymptoms()+"#"+var1.getStatus();
        File file = new File("Appointment.txt");
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
    public boolean update(Appointment var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Appointment search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Appointment> getAll() throws Exception {
        return null;
    }

    @Override
    public int getLastAppointmentID() throws Exception {
        try{
            String appointmentId;
            File file = new File("Appointment.txt");
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
                appointmentId=details[0];
                return Integer.parseInt(appointmentId.substring(4));
            }



        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return 0;
    }
}
