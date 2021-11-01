/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author Walter White
 */
public class StudentList {

    ArrayList<Student> studentList = new ArrayList<>();
    
    public StudentList() {
        this.readFile();
    }
    // Search Student return pos
    public int searchStudentByID(String StudentID) {
        for (int i = 0; i < studentList.size(); i++) {
            if (StudentID.equalsIgnoreCase(studentList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }
    
    //    search Student ra nguyên Student

    public Student searchObjectStudentByID(String StudentId) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (Student student : studentList) {
            if (student.getId().equalsIgnoreCase(StudentId)) {
                return student;
            }
        }
        return null;
    }

    // Add new Student
    public void addStudent() {
        int pos;
        String studentId, name;
        studentId = null;
        name = null;
        do {
            studentId = MyToys.getID("Enter student's ID (AAXXXXXX): ",
                    "The format of ID is AAXXXXXX", "^((SE)|(SS))\\d{6}$");
            pos = searchStudentByID(studentId);
            if (pos != -1) {
                System.err.println("The StudentID is already exist");
            }
        } while (pos != -1);
        name = MyToys.getAName("Enter student's name: ",
                "Không bỏ trống tên. Tên chỉ gồm các kí tự và khoảng trắng");
        studentList.add(new Student(studentId, name));

        System.out.println("A student profile is sucessfully added to file");
    }
    public String checkAddStudent() {
        int pos;
        String studentId, name;
        studentId = null;
        name = null;
        do {
            studentId = MyToys.getID("Enter student's ID (AAXXXXXX): ",
                    "The format of ID is AAXXXXXX", "^((SE)|(SS))\\d{6}$");
            pos = searchStudentByID(studentId);
            if (pos != -1) {
                return studentId;
            }
        } while (pos != -1);
        boolean c = true;
        while (c){
            System.out.println("Do you want to add new Student?");
            c = menuYesNo();
            if (c == true){
            name = MyToys.getAName("Enter student's name: ",
                "Không bỏ trống tên. Tên chỉ gồm các kí tự và khoảng trắng");
        studentList.add(new Student(studentId, name));

        System.out.println("A student profile is sucessfully added to file");
            }break;
        }return studentId;
       
    }

    // read, write file
    public ArrayList<Student> readFile() {
        try {
            FileReader fr = new FileReader("student.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(";");
                String id = txt[0];
                String name = txt[1];
                studentList.add(new Student(id, name));

            }

        } catch (Exception e) {
        }
        return studentList;
    }


    public void printStudentList() {
        if (studentList.isEmpty()) {
           
        }

        for (Student student : studentList) {
            student.showProfile();
        }
    }

    public String searchStudentById() {
        String studentId = null;
        Student s= null;
       
     
            studentId = MyToys.getID("Enter student's ID (AAXXXXXX): ",
                    "The format of ID is AAXXXXXX", "^((SE)|(SS))\\d{6}$");
            s = searchObjectStudentByID(studentId);
            if (s != null) {
                return s.getId();
                             
        } return null;
    }

    public static boolean menuYesNo() {
        boolean flat = true;
        while (flat) {
            System.out.println("1.Yes");
            System.out.println("2.No");
            int choose;
            do {

                choose = MyToys.getAnInteger("Enter your choose:",
                        "Choice must be interger! ");
            } while (choose < 0 || choose > 2);
            switch (choose) {
                case 1: {
                    return true;
                }
                case 2: {

                    return false;
                }
            }
        }
        return flat;
    }
    
    public String searchStudentNameByID(String studentID) {
        if (studentList.isEmpty()) {
            return null;
        }
        for (Student student : studentList) {
            if (student.getId().equals(studentID)) {
                return student.getName();
            }
        }
        return null;
    }
}
