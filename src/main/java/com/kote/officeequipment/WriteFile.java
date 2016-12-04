package com.kote.officeequipment;

import java.io.*;
import java.util.*; 
//import static java.lang.System.out;
/*import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;*/
 
public class WriteFile  {
	//запишем в файл в виде команды потом читать можно тем же методом что и писать
	public static List<Equipment> EquipWrite = new ArrayList<Equipment>();
	
	private static final String ERROR_CANNOT_ACCESS_FILE = "Cannot access file";

	//@Override		
	public static void Add(List<Equipment> EquipWrite) {//throws Exception { 
        try (FileOutputStream fos = new FileOutputStream(OfficeEquipment.FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(EquipWrite);
        } catch (Exception e) {
            new Exception(ERROR_CANNOT_ACCESS_FILE);
        }
	}
		/*try {
			FileWriter writer = new FileWriter(Sklad_Info.FILE_NAME, true);//Paths.get()
			for (Equipment lPr: Equipments) {
			  s = lPr.read();
			writer.write(s+ System.lineSeparator());
			System.out.println(s);	
					}
			writer.close();
			/*Command Comm = new Command();
			Comm.AddCommand(line);*/
     /*  } catch (IOException ex) {
            ex.printStackTrace(); //return ex.toString();//ex.printStackTrace; //Collections.EMPTY_LIST;
        }*/
	
	//String[] Arr = Arrays.deepToString(EquipWrite);//Arrays.toString(EquipWrite);
	//запись в файл всего массива предметов пока тоже макет
	//String[] arr = list.toArray(new String[list.size()]);
	//Arrays.deepToString(EquipWrite)
	//Files.write(Paths.get(Sklad_Info.FILE_NAME), Arr, StandardCharsets.UTF_8);
	//try {
  //          Files.lines(Paths.get(Sklad_Info.FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
   //     } catch (IOException e) {
   //         e.printStackTrace();       
    //    }
	//}
}