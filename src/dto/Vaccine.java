
package dto;

/**
 *
 * @author Walter White
 */
public class Vaccine implements Comparable<Vaccine>{
    private int vaccineId;
    private String vaccineName;
    public Vaccine() {
        vaccineId = 0;
        vaccineName = "";
    }

    public Vaccine(int vaccineId, String vaccineName) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }
    
   @Override
    public String toString() {
        return vaccineId + ";" + vaccineName;
    }
    
    public void showProfile() {
        System.out.printf("|%-8d|%-25s|\n", vaccineId,vaccineName);
    }
    
    @Override
    public int compareTo(Vaccine that) {
        if (this.vaccineId < that.getVaccineId()) {
            return -1;
        }else if (this.vaccineId > that.getVaccineId()) {
            return 1;
        }
        return 0;
    }
}
