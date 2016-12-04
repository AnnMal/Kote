/**
* Sklad_Info
* Приложение командной строки, 
* ведущее упрощённый количественный учёт различной техники организации.
*/
package com.kote.officeequipment;

import main.java.com.kote.officeequipment.commands.Command;
import main.java.com.kote.officeequipment.commands.CommandAdd;
import main.java.com.kote.officeequipment.commands.CommandDel;
import main.java.com.kote.officeequipment.commands.CommandList;
import main.java.com.kote.officeequipment.dbase.ReadFile;
import main.java.com.kote.officeequipment.dbase.WriteFile;
import main.java.com.kote.officeequipment.eq.Equipment;
import ru.prgmt.warehouse.application.*;
import ru.prgmt.warehouse.application.result.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/** Основной класс склада */
public class OfficeEquipment {
 
    public static String FILE_NAME = "officeequipment.dat";
    public static int COLLINES = 1;

    public static List<Equipment> Equipments = new ArrayList<Equipment>();

    public ReadFile ReF = new ReadFile();


    public static void main(String[] args) {
			new OfficeEquipment().run();
		}

    public void run() {
        boolean NoFirst = false;
        Command Comm = new Command();
        try {
            Equipments = ReF.readF();
            System.out.println(Equipments.size());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        while ((!Comm.name.equals(Comm.Commands[0])) || (!NoFirst)) {
            Comm.doCommand();
            NoFirst =true;
            Thread t = new Thread(new Runnable() {
                public void run() {
                    if(Comm.name.startsWith(Comm.Commands[1])) {
                        //list----------------------------
                        CommandList coml = new CommandList();
                        coml.listCommand(Comm.name);
                        //--------------------------list
                    } else if(Comm.name.startsWith(Comm.Commands[2]))

                    {
                        //add--------------------------
                        CommandAdd coma = new CommandAdd();
                        coma.addCommand(Comm.name);
                        //--------------------------add
                    } else if(Comm.name.startsWith(Comm.Commands[3]))

                    {
                        //delete--------------------------
                        CommandDel comd = new CommandDel();
                        comd.delCommand(Comm.name);
                        //--------------------------delete
                    } else if(!Comm.name.equals(Comm.Commands[0]))

                    {
                        System.out.println(Comm.name + ". No so Command!!!");
                    }
                }
            });
            t.start();
        }
    //}
			WriteFile.Add(Equipments);
			System.out.println("End of Program");
		}
}




 
