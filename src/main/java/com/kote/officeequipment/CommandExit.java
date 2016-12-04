/** Класс команд */

package main.java.com.kote.officeequipment;

import com.kote.officeequipment.*;

import java.lang.System.*;

public class CommandExit extends com.kote.officeequipment.Command {

    public String name;

    public CommandExit() {
        //Command CommandExit = new Command();
        //name = com.kote.officeequipment.Command.Commands[0];
        System.exit(0);
    }

}