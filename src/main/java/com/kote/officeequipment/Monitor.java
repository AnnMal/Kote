/**
* Монитор.
* Диагональ, дюймов.
* Признак цветного/чёрно-белого.
* Тип: ЭЛТ, ЖК, проектор.
*/

//add --type MONITOR --name "ViewSonic VA2223WM" --quantity 1 --date 01.11.2016 --color BW --kind LCD

package com.kote.officeequipment;

import java.text.SimpleDateFormat;
import java.util.*;

public class Monitor extends Equipment {

	private int size;
	private boolean color = false;
	private String kind; 							//= {"ЭЛТ", "ЖК", "проектор"};

	/** конструктор */
	Monitor(int i, String t, String n, int q, boolean c, int s, String k) {
		SimpleDateFormat format1 = new SimpleDateFormat( "dd.MM.yyyy");
		Date dat = new Date();
		sku = i ;
		type = t;
		name = n;
		dateWorks = format1.format(dat);			//new Date();
		quantity = q;
		color = c;
		size = s;
		kind = k;
	}

	//01.11.2016 1 штука Монитор "ViewSonic VA2223WM" - цветной ЖК, 22 дюйма
	void read() {
		System.out.println("N " + sku + ": " + dateWorks + " " + quantity + " pieces " + type + " \""  + name + "\" - " +
				size + " " + color + " " + kind);
	};
}	 