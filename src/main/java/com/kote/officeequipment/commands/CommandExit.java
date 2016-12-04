/** Класс команд */

package main.java.com.kote.officeequipment.commands;

public class CommandExit extends Command {

    public String name;

    public CommandExit() {
        //Command CommandExit = new Command();
        //name = com.kote.officeequipment.Command.Commands[0];
        System.exit(0);
    }

}