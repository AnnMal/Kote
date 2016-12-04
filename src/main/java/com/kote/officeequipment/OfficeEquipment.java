/**
* Sklad_Info
* Приложение командной строки, 
* ведущее упрощённый количественный учёт различной техники организации.
*/
package com.kote.officeequipment;

import ru.prgmt.warehouse.application.*;
import ru.prgmt.warehouse.application.result.*;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/** Основной класс склада */
public class OfficeEquipment implements ApplicationController {
 
    public static String FILE_NAME = "officeequipment.dat";
    public static int COLLINES = 1;

    public static List<Equipment> Equipments = new ArrayList<Equipment>();

    public ReadFile ReF = new ReadFile();

    public Map<String, String> getAvailableCommands() {
        return null;
    }

    public CommandResult executeCommand(String name, Map<String, String> parameters, Paging paging) throws CommandNotFoundException {
        int pp = paging.getPageNumber();
        int ts = Equipments.size() - COLLINES*(pp-1);

        List<Equipment> eq = new ArrayList<Equipment>(ts);

        System.out.println(eq.size());
        if (ts>COLLINES) {
           // eq.Add(Equipments.get(1));
            System.arraycopy(Equipments, COLLINES*(pp-1), eq, 0, COLLINES);
        } else System.arraycopy(Equipments, COLLINES*(pp-1), eq, 0, ts);

        String s = paging.getSortProperty();
        //Arrays.sort(eq);
        Page p = new Page(eq, paging, COLLINES); //Equipments.size()
        PagedResult pr = new PagedResult(p);

        eq = p.getContent();
        //for (int j=0; j<2; j++) {
        //for (Equipment lPr : eq) {
            //System.out.println(paging.getPageNumber());
            //lPr.read();
       //     System.out.println(eq.get(0));
        //}
        return pr;
    }

    public static void main(String[] args) {
			new OfficeEquipment().run();
		}

    public void run() {
        final boolean[] NoFirst = {false};
        Command Comm = new Command();
        try {
            Equipments = ReF.readF();
            System.out.println(Equipments.size());
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        while ((!Comm.name.equals(Comm.Commands[0])) || (!NoFirst[0])) {
            Comm.doCommand();
            NoFirst[0] =true;
            Thread t = new Thread(new Runnable() {
                //@Override
                public void run() {
                    if(Comm.name.startsWith(Comm.Commands[1])) {
                        //list----------------------------
                        int cp = (int) Math.ceil((Equipments.size()/COLLINES));
                        for (int i=1; i<=cp; i++) {
                        Paging page = new Paging(i, COLLINES, "name", true);
                            System.out.println(page.getPageNumber());
                        try {
                            executeCommand(Comm.Commands[1], null, page);
                        } catch (CommandNotFoundException e) {
                            System.out.println(e);
                        }}
                        //--------------------------list
                    } else if(Comm.name.startsWith(Comm.Commands[2]))

                    {
                        //add--------------------------
                        System.out.println(Comm.AddCommand(Comm.name));
                        //проверить нет ли уже такого предмета и добавить предмет или добавить количество
                        //Equipments.add(new Printer());
                        //--------------------------add
                    } else if(Comm.name.startsWith(Comm.Commands[3]))

                    {
                        //delete--------------------------
                        Comm.DelCommand(Comm.name);
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




 
