/**
*  Основной класс предметов.
*  Общие свойства предметов учёта:	
*  Номер
*  Наименование
*  Дата ввода в эксплуатацию
*  Количество
*/

package com.kote.officeequipment;

import java.io.Serializable;
import java.util.*;

public abstract class Equipment implements Serializable {
	public int sku;
	public String type;
	public String name;
	//public Date dateWorks;
	public String dateWorks;
	public int quantity;
		
	void read(){}             
}
	 
