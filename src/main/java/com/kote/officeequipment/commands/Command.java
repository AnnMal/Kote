/** Класс команд */

package main.java.com.kote.officeequipment.commands;

import main.java.com.kote.officeequipment.dbase.WriteFile;

public class Command {

    public String name = "";

    public String[] Commands = {"exit", "list", "add", "delete"};

    public WriteFile WrF = new WriteFile();

    /** Новая команда */
    public void doCommand (){
        java.util.Scanner sc = new java.util.Scanner(System.in);;
        System.out.println("I am wait command:");
        System.out.println("list, add, delete or exit");
        name = sc.nextLine();
    }

    public void addCommand(String name) {
    }

    public void delCommand(String name) {
    }

    public void listCommand(String name) {
    }

}