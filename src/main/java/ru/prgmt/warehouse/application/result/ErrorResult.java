package ru.prgmt.warehouse.application.result;

/**
 * Модель ошибочного результата
 */
public class ErrorResult implements CommandResult {
    /**
     * Сообщение об ошибке
     */
    private String message;

    /**
     * Конструктор
     * @param message Сообщение об ошибке
     */
    public ErrorResult(String message) {
        this.message = message;
    }

    /**
     * Получить сообщение об ошибке
     * @return Сообщение об ошибке
     */
    public String getMessage() {
        return message;
    }
}
