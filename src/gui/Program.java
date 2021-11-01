package gui;

import dao.InjectionList;
import dto.Menu;
import java.text.ParseException;

/**
 *
 * @author Walter White
 */
public class Program {

    public static void main(String[] args) throws ParseException {
        InjectionList injecList = new InjectionList();

        Menu doctorMenu = new Menu("Welcome to Covid-19 Vaccine Management-@2021 by <SE151471-Hoang Minh Tuan>");
        doctorMenu.addNewOption("1.Show information all students have been injected");
        doctorMenu.addNewOption("2.Add student's vaccine injection information");
        doctorMenu.addNewOption("3.Updating information of students' vaccine injection");
        doctorMenu.addNewOption("4.Delete student vaccine injection information");
        doctorMenu.addNewOption("5.Search for injection information ");       
        doctorMenu.addNewOption("6.Others - Quit");

        int choice;
        do {

            doctorMenu.printMenu();
            choice = doctorMenu.getChoice();
            switch (choice) {
                case 1: {
                    System.out.println("=========Show information all students have been injected=======");
                    injecList.showInjectionList();
                    break;
                }
                case 2: {
                    boolean c = true;// c sand for continue
                    while (c) {
                        System.out.println("=========Add student's vaccine injection information=======");
                        injecList.addFirstInjection();
                        System.out.println("Do you want to continue Add ?");
                        c = injecList.menuYesNo();
                        injecList.writeFile();
                    }
                    break;
                }
                case 3: {
                    boolean c = true;// c sand for continue
                    while (c) {
                        System.out.println("=========Updating information of students' vaccine injection=======");
                        injecList.updateInjection();
                        System.out.println("Do you want to countinue update? ");
                        c = injecList.menuYesNo();
                        injecList.writeFile();

                    }
                    break;
                }
                case 4: {
                    boolean c = true;// c sand for continue
                    while (c) {
                        System.out.println("========Delete student vaccine injection information=======");
                        injecList.deleteInjection();
                        System.out.println("Do you want to countinue delete? ");
                        c = injecList.menuYesNo();
                        injecList.writeFile();
                    }
                    break;
                }
                case 5: {
                    boolean c = true;// c sand for continue
                    Menu subMenu = new Menu("Search for injection information:");
                    subMenu.addNewOption("5.1 Search by studentID");
                    subMenu.addNewOption("5.2 Search by studentName");
                    int subchoice;
                    do {
                        subMenu.printMenu();
                        subchoice = subMenu.getChoice();
                        switch (subchoice) {
                            case 1: {
                                while (c) {
                                    System.out.println("========Search for injection information by Student ID========");
                                    injecList.searchInjectionByStudentID();
                                    System.out.println("Do you want to countinue search? ");
                                    c = injecList.menuYesNo();
                                }
                                break;
                            }
                            case 2: {
                                while (c) {
                                    System.out.println("========Search for injection information by student Name========");
                                    injecList.searchInjectionByStudentName();
                                    System.out.println("Do you want to countinue search? ");
                                    c = injecList.menuYesNo();

                                }
                                break;
                            }
                        }

                    } while (subchoice != 2);
                    break;
                }
                case 6: {
                    injecList.writeFile();
                    injecList.writeFileWithMD5();
                    System.out.println("=========Others - Quit=======");
                    System.out.println("See you, enjoy!");
                    break;
                }
            }
        } while (choice != 6);

    }

}
