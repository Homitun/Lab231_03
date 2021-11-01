package dto;

/**
 *
 * @author Walter White
 */
public class Student implements Comparable<Student>{
    private String studentId;
    private String studentName;
    
    public Student(){
      studentId = "";
      studentName = "";
    }

    public Student(String id, String name) {
        this.studentId = id;
        this.studentName = name;
    }

    public String getId() {
        return studentId;
    }

    public String getName() {
        return studentName;
    }
       
    public void setName(String name) {
        this.studentName = name;
    }
    
     @Override
    public String toString() {
        return studentId + ";" + studentName;
    }
    
    public void showProfile() {
        System.out.printf("|%-8s|%-25s|\n", studentId, studentName);
    }
    
     @Override
    public int compareTo(Student that) {
        return this.studentId.compareToIgnoreCase(that.studentId);
    }
    
    
 
}
