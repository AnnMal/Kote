/**
* Сканер.
* Признак цветного/чёрно-белого.
* Доступные типы сетевого подключения: нет, проводное, беспроводное.
*/

package com.kote.officeequipment;

import java.text.SimpleDateFormat;
import java.util.*;

public class Scanner extends Equipment {
	private boolean color = false;
	private boolean network;//private String[] network={"нет", "проводное", "беспроводное"};

	/** конструктор */
	Scanner(int i, String t, String n, int q, boolean c, boolean nn) {
		SimpleDateFormat format1 = new SimpleDateFormat ("dd.MM.yyyy");
		Date dat = new Date();
		sku = i ;
		type = t;
		name = n;
		dateWorks = format1.format(dat);//new Date();
		quantity = q;
		color = c;
		network = nn;
	}

	void read() {
		System.out.println("N " + sku + ": " + dateWorks + " " + quantity + " pieces " + type + " \""  + name + "\" - " +
				this.network + " " + this.color);
	};
}	  	