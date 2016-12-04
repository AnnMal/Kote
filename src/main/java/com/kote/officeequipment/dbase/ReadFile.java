package main.java.com.kote.officeequipment.dbase;

import java.io.*;
import java.util.*;
import main.java.com.kote.officeequipment.eq.Equipment;

public class ReadFile  {

	public static List<Equipment> EquipRead = new ArrayList<Equipment>();
	private static final String ERROR_CANNOT_ACCESS_FILE = "Cannot access file";

	public List<Equipment> readF()  throws Exception {
        try (FileInputStream fin = new FileInputStream(com.kote.officeequipment.OfficeEquipment.FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            return (List<Equipment>) ois.readObject();
        }
        catch (Exception e) {
            throw new Exception(ERROR_CANNOT_ACCESS_FILE);
        }
    }
}