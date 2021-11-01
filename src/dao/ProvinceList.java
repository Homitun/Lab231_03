/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Province;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import util.MyToys;

/**
 *
 * @author Walter White
 */
public class ProvinceList {

    ArrayList<Province> pList = new ArrayList<>();
    
    public ProvinceList() {
        this.readFile();
    }
    public int searchProvinceByID(int ID) {
        for (int i = 0; i < pList.size(); i++) {
            if (ID == pList.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public Province searchObjectproProvinceByID(int Id) {
        if (pList.isEmpty()) {
            return null;
        }

        for (Province province : pList) {
            if (province.getId() == Id) {
                return province;
            }
        }
        return null;
    }

    public ArrayList<Province> readFile() {
        try {
            FileReader fr = new FileReader("province.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            System.out.println(line);
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String[] txt = line.split(";");
                int id = Integer.parseInt(txt[0]);
                String name = txt[1];
                pList.add(new Province(id, name));

            }

        } catch (Exception e) {
        }
        return pList;
    }

    public void printProvinceList() {
        if (pList.isEmpty()) {
            System.out.println("The list is empty. Nothing to print");
            return;
        }
        for (Province province : pList) {
            province.showProfile();
        }

    }

    public String searchPlaceByName() {
        String searchProvince;
        searchProvince = MyToys.getAName("Enter injection place: ", "Injection place must be fill!");
        ArrayList<Province> listOfFound = new ArrayList<>();
        for (Province province : pList) {
            if (province.getName().contains(searchProvince)) 
                listOfFound.add(province);
            if (searchProvince.equalsIgnoreCase(province.getName())) 
                return searchProvince;
        }
        if (listOfFound.isEmpty()) {
            System.out.println("Notfound!");
        }else for (Province province : listOfFound) 
                 province.showProfile();
        return null;
        }
    }

