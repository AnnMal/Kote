package main.java.com.kote.officeequipment.dbase;

import main.java.com.kote.officeequipment.eq.Equipment;

import java.io.*;
import java.util.*;
 
public class WriteFile  {
	//запишем в файл в виде команды потом читать можно тем же методом что и писать
	public static List<Equipment> EquipWrite = new ArrayList<Equipment>();
	
	private static final String ERROR_CANNOT_ACCESS_FILE = "Cannot access file";

	//@Override		
	public static void Add(List<Equipment> EquipWrite) {//throws Exception { 
        try (FileOutputStream fos = new FileOutputStream(com.kote.officeequipment.OfficeEquipment.FILE_NAME);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(EquipWrite);
        } catch (Exception e) {
            new Exception(ERROR_CANNOT_ACCESS_FILE);
        }
	}

}