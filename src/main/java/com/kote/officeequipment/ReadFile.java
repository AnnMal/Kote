package com.kote.officeequipment;

import java.io.*;
import java.util.*;

public class ReadFile  {

	public static List<Equipment> EquipRead = new ArrayList<Equipment>();
	private static final String ERROR_CANNOT_ACCESS_FILE = "Cannot access file";

	public List<Equipment> readF()  throws Exception {
	//public Map<String, Device> getData() throws Exception {
        //initFile();
        try (FileInputStream fin = new FileInputStream(OfficeEquipment.FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fin)) {
            return (List<Equipment>) ois.readObject();
        }
        catch (Exception e) {
            throw new Exception(ERROR_CANNOT_ACCESS_FILE);
			//return null;
        }
		//return null;
    }
}
		/*try {
			Stream<String> lines = Files.lines(Paths.get(Sklad_Info.FILE_NAME));
 			lines.forEach(line -> {
			Command Comm = new Command();
			Comm.AddCommand(line);
			} );
       } catch (IOException ex) {
            ex.printStackTrace(); //return ex.toString();//ex.printStackTrace; //Collections.EMPTY_LIST;
        }*/
		//lines.forEach(Consumer<? super String>) line -> {
            /*Student student = new Student();
            StringTokenizer sToken = new StringTokenizer(line, " ");
            student.setIdStudent(Integer.valueOf(sToken.nextToken()));
            student.setName(sToken.nextToken());
            students.add(student);*/
	  // чтение файла пока только макет
	  // считать все надо в массив предметов
		//for (Equipment lPr: EquipWrite) {
		//				lPr.read();
		//			}
       //    Files.lines(Paths.get(Sklad_Info.FILE_NAME), StandardCharsets.UTF_8).forEach(System.out::println);
       //    Files.lines(Paths.get(Sklad_Info.FILE_NAME), StandardCharsets.UTF_8).forEach(EquipRead);

	//не забыть
   //	System.out.println("БД не содержит записей");


//}