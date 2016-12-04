package ru.prgmt.warehouse.application.result;

/**
 * Модель результата, требующего дополниительного ввода данных
 */
public class PromptResult implements CommandResult {
    /**
     * Название параметра, в который поместить ответ
     */
    private String parameterKey;
    /**
     * Сообщение запроса
     */
    private String prompt;
    /**
     * Подсказка по вводу значения ("строка", "число", "вариант1, вариант2", и т.п.)
     */
    private String valueHint;

    /**
     * Конструктор
     * @param parameterKey Параметр ответа
     * @param prompt Сообщение запроса
     * @param valueHint Подсказка по вводу значения
     */
    public PromptResult(String parameterKey, String prompt, String valueHint) {
        this.parameterKey = parameterKey;
        this.prompt = prompt;
        this.valueHint = valueHint;
    }

    /**
     * Получить название параметра ответа
     * @return Название параметра
     */
    public String getParameterKey() {
        return parameterKey;
    }

    /**
     * Получить запрос
     * @return Сообщение
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Получить подсказку по вводу
     * @return Подсказка
     */
    public String getValueHint() {
        return valueHint;
    }
}
