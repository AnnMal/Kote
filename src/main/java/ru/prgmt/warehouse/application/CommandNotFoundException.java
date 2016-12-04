package ru.prgmt.warehouse.application;

public class CommandNotFoundException extends Exception {
    public CommandNotFoundException(String name) {
        super("Команда '" + name + "' не найдена");
    }
}
