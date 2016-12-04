package ru.prgmt.warehouse.application;

import java.util.List;

/**
 * Страница со значениями
 * @param <T> Тип значения
 */
public class Page<T> {
    /**
     * Список значений
     */
    private List<T> content;
    /**
     * Изначальный запрос постраничной навигации
     */
    private Paging paging;
    /**
     * Общее количество найденyых записей
     */
    private int total;

    /**
     * Конструктор
     * @param content Список значений
     * @param paging Запрос постраничной навигации
     * @param total Общее количество значений
     */
    public Page(List<T> content, Paging paging, int total) {
        this.content = content;
        this.paging = paging;
        this.total = total;
    }

    /**
     * Получить срдержимое страницы
     * @return Список значений
     */
    public List<T> getContent() {
        return content;
    }

    /**
     * Получить запрос постраничной навигации
     * @return Запрос
     */
    public Paging getPaging() {
        return paging;
    }

    /**
     * Получить общее количество значений
     * @return Количество значений
     */
    public int getTotal() {
        return total;
    }
}
