package lk.usj.OPD_Management.java.dao.custom.Impl;

import lk.usj.OPD_Management.java.dao.custom.VisitorDAO;
import lk.usj.OPD_Management.java.entity.Visitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VisitorDAOImpl implements VisitorDAO {
    @Override
    public boolean save(Visitor var1) throws Exception {
        return false;
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
        try{
            String visitorName, purpose, telNo, NICNo,visitDay, visitMonth, visitYear, inTimeHour,inTimeMinutes, inTimeAMPM,outTimeHour,outTimeMinutes,outTimeAMPM,attachment,notes;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            File file = new File("Visitor.txt");
            Scanner scanner =new Scanner(file);

            List<Visitor> visitors = new ArrayList<>();

            while(scanner.hasNextLine()){
                String line =scanner.nextLine();
                String[] details = line.split(",");
                visitorName =details[0];
                purpose =details[1];
                telNo =details[2];
                NICNo =details[3];
                visitDay =details[4];
                visitMonth=details[5];
                visitYear =details[6];
                inTimeHour =details[7];
                inTimeMinutes =details[8];
                inTimeAMPM=details[9];
                outTimeHour=details[10];
                outTimeMinutes=details[11];
                outTimeAMPM=details[12];
                attachment=details[13];
                notes=details[14];



                try {

                    Visitor visitor=new Visitor(visitorName, purpose, telNo, NICNo,visitDay,visitMonth, visitYear, inTimeHour,inTimeMinutes, inTimeAMPM,outTimeHour,outTimeMinutes,outTimeAMPM,attachment,notes);
                    visitors.add(visitor);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            for (Visitor a:visitors){
                if(a.getVisitorName().equals(var1)){
                    return a;
                }
            }

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Visitor> getAll() throws Exception {
        return null;
    }
}
