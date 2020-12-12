package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.AdminDAO;
import lk.usj.OPD_Management.java.entity.Admin;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public boolean save(Admin var1) throws Exception {
        return false;
    }

    @Override
    public boolean update(Admin var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Admin search(String var1) throws Exception {
        /*File file = new File("Admin.txt");
        if (!file.exists()) {//checking the is given file exists

            file.createNewFile();//creating new file
            Exception fileError =new IOException("File is not founded");
            System.out.println(fileError);
        }*/
        try{
            String username, name, gender, phoneNumber, idCard, address, maritalStatus, password;
            String dateOfBirth;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Admin.txt");
            Scanner scanner =new Scanner(file);

            List<Admin> admins = new ArrayList<>();

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
                try {
                    Date date =format.parse(dateOfBirth);
                    Admin admin= new Admin(username, name, gender, phoneNumber, idCard,date, address, maritalStatus, password);
                    admins.add(admin);
                }catch (ParseException e){
                    e.printStackTrace();
                }
            }
            for (Admin a:admins){
                if(a.getUsername().equals(var1)){
                    return a;
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Admin> getAll() throws Exception {
        return null;
    }
}
