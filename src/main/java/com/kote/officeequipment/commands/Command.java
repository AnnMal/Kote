/** Класс команд */

package main.java.com.kote.officeequipment.commands;

import main.java.com.kote.officeequipment.dbase.WriteFile;
import ru.prgmt.warehouse.application.result.*;
import ru.prgmt.warehouse.application.*;
import java.util.*;
import java.io.*;
import java.util.regex.*;

public class Command {

    public String name = "";

    //public String NewCommand = "";

    public String[] Commands = {"exit", "list", "add", "delete"};

    public WriteFile WrF = new WriteFile();

    /** Новая команда */

    //public void Command() {};

    public void doCommand (){
        java.util.Scanner sc = new java.util.Scanner(System.in);;
        System.out.println("I am wait command:");
        System.out.println("list, add, delete or exit");
        name = sc.nextLine();
    }

    public String AddCommand(String name) {
        return "";
    }

    public String DelCommand(String name) {
        return "";
    }
}