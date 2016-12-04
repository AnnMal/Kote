/** Класс команд */

package main.java.com.kote.officeequipment.commands;

import main.java.com.kote.officeequipment.eq.Equipment;
import ru.prgmt.warehouse.application.*;
import ru.prgmt.warehouse.application.result.*;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandDel extends Command{

    public String name = "delete";


    /** Удаление */

   // @Override
    public void delCommand(String Com) {
        Pattern p = Pattern.compile("delete --sku (\\d+)",Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(Com);
        if (!m.matches()) {
            System.out.println("ERROR! For delete you mast use this command format: delete --sku <number>.");
        } else {
            //System.out.println(m.group(1));
            for (Equipment lPr: com.kote.officeequipment.OfficeEquipment.Equipments) {
                if (lPr.sku==Integer.valueOf(m.group(1))) {
                    com.kote.officeequipment.OfficeEquipment.Equipments.remove(lPr);
                    System.out.println("SUCCESSFUL DELETE");
                    break;
                }
            }
        }
        //return("SUCCESSFUL DELETE");
    }


}