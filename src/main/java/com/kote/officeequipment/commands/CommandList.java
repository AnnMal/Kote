/** Класс команд */

package main.java.com.kote.officeequipment.commands;

import main.java.com.kote.officeequipment.eq.Equipment;
import ru.prgmt.warehouse.application.*;
import ru.prgmt.warehouse.application.result.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

import static com.kote.officeequipment.OfficeEquipment.COLLINES;
import static com.kote.officeequipment.OfficeEquipment.Equipments;

public class CommandList implements ApplicationController{

    public String name = "list";

    public Map<String, String> getAvailableCommands() {
        return null;
    }

    public ru.prgmt.warehouse.application.result.CommandResult executeCommand(String name, Map<String, String> parameters, Paging paging) throws CommandNotFoundException {
        int pp = paging.getPageNumber();
        int ts = Equipments.size() - COLLINES*(pp-1);

        List<Equipment> eq = new ArrayList<Equipment>(ts);

        if (ts>COLLINES) {
            // eq.Add(Equipments.get(1));
            System.arraycopy(Equipments, COLLINES*(pp-1), eq, 0, COLLINES);
        } else System.arraycopy(Equipments, COLLINES*(pp-1), eq, 0, ts);

        String s = paging.getSortProperty();
        //Arrays.sort(eq);
        Page p = new Page(eq, paging, COLLINES); //Equipments.size()
        PagedResult pr = new PagedResult(p);

        eq = p.getContent();
        for (Equipment lPr : eq) {
           // lPr.read();
        }
        return pr;
    }


    public void listCommand(String name) {
        int cp = (int) Math.ceil((Equipments.size()/COLLINES));
        for (int i=1; i<=cp; i++) {
            ru.prgmt.warehouse.application.Paging page = new Paging(i, COLLINES, "name", true);
            System.out.println(page.getPageNumber());
            try {
                executeCommand(name, null, page);
            } catch (ru.prgmt.warehouse.application.CommandNotFoundException e) {
                System.out.println(e);
            }}

    }

}