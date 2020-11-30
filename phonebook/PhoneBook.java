/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 *
 * @author Pollock
 */
public class PhoneBook {

    /**
     * @param args the command line arguments
     */
    public static HashMap<String, String> hm = new HashMap<>();

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        int i = 9;
        while (i != 0) {
            System.out.println("Press 1 to Add.\n"
                    + "Press 2 to Search.\n" + "Press 3 to Delete.\n"
                    + "Press 4 to Show All Contacts.\n" + "Press 5 to Exit.\n");

            int a = sc.nextInt();

            if (a == 1) {
                add();
            } else if (a == 2) {

                find();
            } else if (a == 3) {

                delete();
            } else if (a == 4) {
                show();

                //System.out.println(hm);
            } else if (a == 5) {
                System.clearProperty("Clear");
            } else {
                System.out.println("Please enter a correct Number.");
            }
        }
    }

    public static void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Name:");
        String name = sc.nextLine();
        System.out.println("Please enter Number:");
        String num = sc.nextLine();

        if (!hm.containsKey(name)) {
            hm.put(name, num);
            System.out.println(name + "'s" + " Number inserted successfully");

        } else if (hm.containsKey(name)) {
            System.out.println(name + "'s" + " Already Exist. Do You Want"
                    + " To Create New Contact ? " + "\nIf YES,"
                    + " Please Press 1 " + "\nOtherwise Press 0.");
            int n = sc.nextInt();
            if (n == 1) {
                // String newName= name+"1";
                hm.remove(name);
                hm.put(name + "1", num);
                System.out.println(name + "'s" + "Nummber Replaced.");
            } else {

            }

        }
    }

    public static void find() {
        System.out.println("Please Enter NAME To Find Contact.");
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();

        if (hm.containsKey(name)) {
            System.out.println("Contact Exists.");

        } else {
            System.out.println(name + "'s" + " Number Not Found.");
        }
    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter NAME To Delete Contact.");
        String name = sc.nextLine();

        if (hm.containsKey(name)) {
            hm.remove(name);
        }
        System.out.println(name + "'s" + " Deleted Successfully.");

    }

    public static void show() {
        for (Entry e : hm.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }
    /*public static void exit() {
     hm.    
     }*/
}


/*class contacts implements Comparable<contacts> {

 String name = " ";
 String number = " ";

 contacts(String name, String num) {
 this.name = name;
 this.number = num;
 }

 @Override
 public String toString() {
 return name + ":" + number + ".";
 }

 @Override
 public int compareTo(contacts t) {
 // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 return name.compareTo(t.name);
 }

 }*/
