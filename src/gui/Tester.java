/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.InjectionList;
import dao.ProvinceList;
import java.text.ParseException;
import dao.StudentList;
import dao.VaccineList;
import util.MyToys;
/**
 *
 * @author Walter White
 */
public class Tester {
    public static void main(String[] args) throws ParseException  {
     InjectionList i = new InjectionList();
     i.inputData();
     i.updateInjection();
       i.readFile();
    
    i.showInjectionList();
// 
//    
//ProvinceList p = new ProvinceList();
//p.readFile();
//p.printProvinceList();

    }
}
