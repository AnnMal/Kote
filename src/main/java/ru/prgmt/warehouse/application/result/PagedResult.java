package ru.prgmt.warehouse.application.result;

import ru.prgmt.warehouse.application.Page;

/**
 * Результат со списком значений
 */
public class PagedResult implements CommandResult {
    /**
     * Страница со значениями
     */
    private Page<?> result;

    /**
     * Конструктор
     * @param result Страница с результатом
     */
    public PagedResult(Page<?> result) {
        this.result = result;
    }

    /**
     * Получить страницу с результатом
     * @return Страница
     */
    public Page<?> getResult() {
        return result;
    }
}
