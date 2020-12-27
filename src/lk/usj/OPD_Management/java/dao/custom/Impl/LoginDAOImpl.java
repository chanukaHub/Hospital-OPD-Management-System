package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.LoginDAO;
import lk.usj.OPD_Management.java.entity.Doctor;
import lk.usj.OPD_Management.java.entity.Login;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public boolean save(Login var1) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strDate = formatter.format(var1.getLoginDateTime());

        String wantedLine = var1.getUserName()+"#"+var1.getName()+"#"+strDate+"#"+var1.getUserType();
        File file = new File("Login.txt");
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
    public boolean update(Login var1) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String var1) throws Exception {
        return false;
    }

    @Override
    public Login search(String var1) throws Exception {
        return null;
    }

    @Override
    public ArrayList<Login> getAll() throws Exception {
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String username, name, date,type;
            File file = new File("Login.txt");
            if (!file.exists()) {//checking the is given file exists

                file.createNewFile();//creating new file
                Exception fileError =new IOException("File is not founded");
                System.out.println(fileError);
            }
            Scanner scanner =new Scanner(file);

            ArrayList<Login> logins = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split("#");
                username=details[0];
                name=details[1];
                date=details[2];
                type=details[3];

                try {
                    Date loginDateTime =formatter.parse(date);
                    Login login= new Login(username, name, loginDateTime,type);
                    logins.add(login);
                }catch (ParseException e){
                    e.printStackTrace();
                }
            }
            return logins;

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
