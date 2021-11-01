/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Walter White
 */
public class Injection implements Comparable<Injection>{
    private int id ;
    private String injectionPlace1,injectionPlace2;
    private Date injectionDate1,injectionDate2;
    private String studentId;
    private int vaccineId;
    private String studentName;

    
    public Injection(){
        id = 0;
        injectionPlace1 = "";
        injectionPlace2 = "";   
        studentId = "";
        vaccineId = 0;
        studentName = "";
    }

    public Injection(int id, String injectionPlace1, String injectionPlace2, 
            Date injectionDate1, Date injectionDate2, String studentId, int vaccineId, String studentName) {
        this.id = id;
        this.injectionPlace1 = injectionPlace1;
        this.injectionPlace2 = injectionPlace2;
        this.injectionDate1 = injectionDate1;
        this.injectionDate2 = injectionDate2;
        this.studentId = studentId;
        this.vaccineId = vaccineId;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public String getInjectionPlace1() {
        return injectionPlace1;
    }

    public void setInjectionPlace1(String injectionPlace1) {
        this.injectionPlace1 = injectionPlace1;
    }

    public String getInjectionPlace2() {
        return injectionPlace2;
    }

    public void setInjectionPlace2(String injectionPlace2) {
        this.injectionPlace2 = injectionPlace2;
    }

    public Date getInjectionDate1() {
        return injectionDate1;
    }

    public void setInjectionDate1(Date injectionDate1) {
        this.injectionDate1 = injectionDate1;
    }

    public Date getInjectionDate2() {
        return injectionDate2;
    }

    public void setInjectionDate2(Date injectionDate2) {
        this.injectionDate2 = injectionDate2;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }
    
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Override
    public String toString() {
         SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
         String d2 = null;
         try{
             d2 = df.format(injectionDate2);
         }catch(Exception e){
             d2= "chưa tiem";
         }
        return  id + ";"+ studentId +";"  +vaccineId+";"+ injectionPlace1 +
                ";" +df.format(injectionDate1)+ ";" + injectionPlace2+ ";"
                +d2+ "\n";
    }
    
    public void showProfile()throws ParseException{
        System.out.println("|InjectionID|Student Name         |Student Id|Vaccine Id|");
        System.out.printf("|%-11s|%-18s|%-9s|%-9d|\n", id,studentName, studentId,vaccineId);  
        System.out.println("Injection Information");
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("|First Vaccination|Place:%-15s|Time:%-8s|\n",injectionPlace1, df.format(injectionDate1));
       showSecondInjection();
        System.out.println("--------------------------------------------------");
    }
    public void showSecondInjection(){
        if(injectionDate2!= null){
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            System.out.printf("|Second Vaccination|Place:%-15s|Time:%-8s|\n", injectionPlace2, df.format(injectionDate2));
        }
    }
    @Override
    public int compareTo(Injection that) {
        if (this.id < that.getId()) {
            return -1;
        }else if (this.id > that.getId()) {
            return 1;
        }
        return 0;
    }
    
}
