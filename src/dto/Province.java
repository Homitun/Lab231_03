/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Walter White
 */
public class Province implements Comparable<Province> {
    private int id;
    private String name;
    public Province() {
        id = 0;
        name = "";
    }
    public Province(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Province{" + "id=" + id + ", name=" + name + '}';
    }
     public void showProfile() {
        System.out.printf("|%-8d|%-50s|\n", id,name);
    }
    
    @Override
    public int compareTo(Province that) {
        if (this.id < that.getId()) {
            return -1;
        }else if (this.id > that.getId()) {
            return 1;
        }
        return 0;
    }
    
}
