/** Класс команд */

package main.java.com.kote.officeequipment.commands;

import main.java.com.kote.officeequipment.eq.*;
import ru.prgmt.warehouse.application.*;
import ru.prgmt.warehouse.application.result.*;

import java.util.Scanner;

public class CommandAdd extends Command{

    public String name = "add";

    public static int indexOfIntArray(int key) {
        int returnvalue = -1;
        for (int i = 0; i < com.kote.officeequipment.OfficeEquipment.Equipments.size(); ++i) {
            //System.out.println(Sklad_Info.Equipments.get(i).sku);
            //System.out.println(Sklad_Info.Equipments.get(i).sku==key);
            if (com.kote.officeequipment.OfficeEquipment.Equipments.get(i).sku==key) {
                //if (Sklad_Info.Equipments[i].sku==key) {
                returnvalue = i;
                return returnvalue;
                //System.out.println(Sklad_Info.Equipments.get(i).sku);
                //break;
            }
        }
        return returnvalue;
    }

    /**
     *   Add
     **/

    public String AddCommand(String Com) {
        //add --sku 3 --type MONITOR --name "ViewSonic VA2223WM" --quantity 1 --date 01.11.2016 --color BW --kind LCD
        //add --sku 17 --type MONITOR --name "ViewSonic VA2223WM" --date 01.11.2016 --color true --size 22 --kind LCD
        //add --sku 17 --type MONITOR --name "ViewSonic VA2223WM" --color true --size 22 --kind LCD
        String Str = Com;
        String[] RStr = Com.split("--");
        //System.out.println(Arrays.toString(RStr));
        Monitor TMo;
        Printer TPr;
        main.java.com.kote.officeequipment.eq.Scanner TSr;
        int Pr = 0;
        String TName = "";
        int TQua = 0;
        int TSku = 0;
        boolean TCol = false;
        int TSiz = 0;
        boolean TNet = false;
        String TKin = "";
        boolean FRep = false;
        boolean FDel = false;
        int indexOfR = -1;
        boolean fArg = false;
        //int size = 0;
        //type name quantity <date> [color size kind] [color network install] [color network]
        boolean[] EArg = {false, false, false, false, false, false, false};
        for (int j = 0; j < RStr.length; j++) {
            if (RStr[j].startsWith("sku")) {
                EArg[0]=true;
                //System.out.println(Arrays.toString(RStr));
                String[] TStr = RStr[j].split(" ");
                if (TStr[1].matches("[0-9]*"))	{
                    TSku = Integer.valueOf(TStr[1]);
                } else {
                    System.err.println("ERROR. Argument <sku> is not number!!");
                }
                if (TStr.length==2) {
                    indexOfR = indexOfIntArray(TSku);
                    //System.out.println(indexOfR);
                    if (indexOfR > -1) {
                        FDel = true;
                    }
                }	else {
                    return "ERROR! No sku! You mast enter this: --sku <number>";
                }
            } else if (RStr[j].startsWith("type")) {
                EArg[1]=true;
                //System.out.println(Arrays.toString(RStr));
                String[] TStr = RStr[j].split(" ");
                if (TStr.length==2) {
                    //System.out.Println(TStr[1]);
                    switch (TStr[1]) {
                        case "MONITOR":
                            Pr=1;
                            break;
                        case "PRINTER":
                            Pr=2;
                            EArg[6]=true;
                            break;
                        case "SCANNER":
                            Pr=3;
                            EArg[6]=true;
                            break;
                    }
                    if (Pr==0) {
                        return("ERROR. Not correct of type! It mast be MONITOR, PRINTER or SCANNER");
                    }
                } else {
                    return("ERROR. No type. It mast be MONITOR, PrINTER or SCANNER");
                }
            } else if (RStr[j].startsWith("name")) {
                EArg[2] = true;
                String[] TStr = RStr[j].split(" ");
                TName = TStr[1];
            } else if (RStr[j].startsWith("quantity")) {
                EArg[3] = true;
                String[] TStr = RStr[j].split(" ");
                if (TStr[1].matches("[0-9]*"))	{
                    TQua = Integer.valueOf(TStr[1]);
                } else {
                    return("ERROR. Argument <quantity> is not number!!");
                }
            } else if (RStr[j].startsWith("color")) {
                EArg[4] = true;
                String[] TStr = RStr[j].split(" ");
                TCol = Boolean.valueOf(TStr[1]);
                //return("ERROR. Argument <color> is not boolean!!");
            } else if (RStr[j].startsWith("size")) {
                EArg[5] = true;
                String[] TStr = RStr[j].split(" ");
                if (TStr[1].matches("[0-9]*"))	{
                    TSiz = Integer.valueOf(TStr[1]);
                } else {
                    return("ERROR. Argument <size> is not number!!");
                }
            }  else if (RStr[j].startsWith("network")) {
                EArg[5] = true;
                String[] TStr = RStr[j].split(" ");
                if ((TStr[1]=="true")||(TStr[1]=="false")) {
                    TNet = Boolean.valueOf(TStr[1]);
                } else {
                    return("ERROR. Argument <network> is not boolean!!");
                }
            } else if (RStr[j].startsWith("kind")) {				//"TUBE", "LCD", "PROJECTOR"
                EArg[6] = true;
                String[] TStr = RStr[j].split(" ");
                //System.out.println(TStr[1]+((TStr[1]=="TUBE")||(TStr[1]=="LCD")||(TStr[1]=="PROJECTOR")));
                //if ((TStr[1]=="TUBE")||(TStr[1]=="LCD")||(TStr[1]=="PROJECTOR")) {
                TKin = TStr[1];
                //} else {
                //	return("ERROR. Argument <kind> mast be only \"TUBE\", \"LCD\" or \"PROJECTOR\"!!");
                //}
            }
        }
        //System.out.println(Arrays.toString(EArg));
        String TempS = "ERROR. No arguments: ";
        for (int i = 0; i < EArg.length; i++) {
            if (!EArg[i]) {
                fArg = true;
                switch (i) {
                    case 0:
                        TempS = TempS + "--sku ";
                        continue;
                    case 1:
                        TempS = TempS + "--type ";
                        continue;
                    case 2:
                        TempS = TempS + "--name ";
                        continue;
                    case 3:
                        TempS = TempS + "--quantity ";
                        continue;
                    case 4:
                        TempS = TempS + "--color ";
                        continue;
                    case 5:
                        if (Pr==1) {
                            TempS = TempS + "--size ";
                        } else {
                            TempS = TempS + "--netework ";
                        }
                        continue;
                    case 6:
                        TempS = TempS + "--kind ";
                        continue;
                }
            }
        }
        if (fArg) {
            return(TempS);
        } else {
            if (FDel) {
                System.out.println("WARNING! So element repeat. Ovewrride this element.");
                //System.out.println(indexOfR);
                DelCommand ("delete --sku "+ TSku);
            }
            switch (Pr) {
                case 1:
                    TMo=new Monitor(TSku, "MONITOR", TName, TQua, TCol, TSiz, "");
                    com.kote.officeequipment.OfficeEquipment.Equipments.add(TMo);
                    break;
                case 2:
                    TPr=new Printer(TSku, "PRINTER", TName, TQua, TCol, false);
                    com.kote.officeequipment.OfficeEquipment.Equipments.add(TPr);
                    break;
                case 3:
                    TSr=new main.java.com.kote.officeequipment.eq.Scanner(TSku, "SCANNER", TName, TQua, TCol, false);
                    com.kote.officeequipment.OfficeEquipment.Equipments.add(TSr);
                    break;
            }
            //System.out.println(Arrays.toString(Sklad_Info.Equipments));
            return("SUCCESSFUL ADD");
        }
    }

}