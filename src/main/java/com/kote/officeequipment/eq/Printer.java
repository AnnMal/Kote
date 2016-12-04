/**
*   Принтер.
*   Признак цветного/чёрно-белого.
*   Признак сетевого.
*   Тип установки: переносной, настольный, стационарный.
*/	 

package main.java.com.kote.officeequipment.eq;

import java.text.SimpleDateFormat;
import java.util.*;

public class Printer extends Equipment {

	private boolean color = false;
	private boolean network = false;
	//private String[] install = {"переносной", "настольный", "стационарный"};
	private String install;

	/** конструктор */
	public Printer(int i, String t, String n, int q, boolean c, boolean nn) {
		SimpleDateFormat format1 = new SimpleDateFormat ("dd.MM.yyyy");
		Date dat = new Date();
		sku = i ;
		type = t;
		name = n;
		dateWorks = format1.format(dat);	//new Date();
		quantity = q;
		color = c;
		network = nn;
	}

	//01.11.2016 1 штука Монитор "ViewSonic VA2223WM" - цветной ЖК, 22 дюйма
	@Override
	public String toString() {
		return "PRINTER" + this.sku + name ;
	}

	void read() {
		System.out.println("N " + sku + ": " + dateWorks + " " + quantity + " pieces " + type + " \""  + name + "\" - " +
				this.network + " " + this.color);
	};

	private void setName(String name) {
		this.name = name;
	}

}	   	
