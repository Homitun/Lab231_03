/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import static dao.StudentList.menuYesNo;
import dto.Vaccine;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author Walter White
 */
public class VaccineList {
    ArrayList<Vaccine> vaccineList = new ArrayList<>();
    
    public VaccineList() {
        this.readFile();
    }
    // Search vaccine return pos
    public int searchVaccineByID(int VaccineID) {
        for (int i = 0; i < vaccineList.size(); i++) {
            if (VaccineID == vaccineList.get(i).getVaccineId()) {
                return i;
            }
        }
        return -1;
    }
    // search vaccine ra nguyen con vaccine
    public Vaccine searchObjectVaccineByID(int vaccineId) {
        if (vaccineList.isEmpty()) {
            return null;
        }
        for (Vaccine vaccine : vaccineList)           
            if (vaccine.getVaccineId()== vaccineId) {
                return vaccine;
            }
        return null;
    }
     public int searchVaccineById() {
        int vaccineId;
        Vaccine v;
         for (Vaccine vaccine : vaccineList) {
             vaccine.showProfile();
         }
        vaccineId = MyToys.getAnInteger("Enter vaccine id", "Vaccine must be interger (1-99)", 1, 99);
        v = searchObjectVaccineByID(vaccineId);
        if (v != null) {
            return v.getVaccineId();
        } else {
            boolean c = false;
            System.out.println("Not found in list!Here is the list of vaccine");
            for (Vaccine vaccine : vaccineList) {
                vaccine.showProfile();
            }
            
            System.out.println("YES to add new vaccine|NO to re-enter");
            c = menuYesNo();
            if (c == true) {
               addVaccine();
            }
        }
        return 0;
    }
    // Add new vaccine
    public void addVaccine() {
        int pos,vaccineId;
        String  name;    
        name = null;
        do {
            vaccineId = MyToys.getAnInteger("Enter vaccine id", "Vaccine must be interger (1-99)", 1, 99);
            pos = searchVaccineByID(vaccineId);
            if (pos != -1) {
                System.err.println("The vaccineID is already exist");
            }
        } while (pos != -1);
        name = MyToys.getAName("Enter Vaccine's name: ",
                "Không bỏ trống tên. Tên chỉ gồm các kí tự và khoảng trắng");
        vaccineList.add(new Vaccine(vaccineId, name));
        System.out.println("A Vaccine infomation is sucessfully added");
    }
    // read file
     public ArrayList<Vaccine> readFile(){
        try{
            FileReader fr = new FileReader("vaccine.dat");
//            FileReader fr = new FileReader("province.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true){
                line  = br.readLine();
                if (line == null){
                    break;
                }
                 String[] txt = line.split(";");
                 int id = Integer.parseInt(txt [0]);
                 String name = txt [1];
                 vaccineList.add(new Vaccine(id, name));
                 
            }
           
        }catch( Exception e){}
        return vaccineList;
    }
      public void writeFile(){
        try{
            FileWriter fw = new FileWriter("vaccine.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            for (Vaccine vaccine : vaccineList) {
                bw.write(vaccineList.toString());
            bw.close();
            fw.close();
            }
            
        }catch (Exception e){}                  
    }
      public void printVaccineList(){
           if (vaccineList.isEmpty()) {
            System.out.println("The list is empty. Nothing to print");
            return;
        }
          for (Vaccine vaccine : vaccineList) {
              vaccine.showProfile();
          }
      }
}
