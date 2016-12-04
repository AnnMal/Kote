package ru.prgmt.warehouse.application;

/**
 * Запрос постраничной навигации
 */
public class Paging {
    /**
     * Номер страницы
     */
    private int pageNumber;
    /**
     * Размер страницы
     */
    private int pageSize;
    /**
     * Название поля сортировки
     */
    private String sortProperty;
    /**
     * Признак сортировки по возрастанию
     */
    private boolean sortAscending;

    /**
     * Конструктор
     * @param pageNumber Номер страницы
     * @param pageSize Размер страницы
     * @param sortProperty Название поля сортировки
     * @param sortAscending Признак сортировки по возрастанию
     */
    public Paging(int pageNumber, int pageSize, String sortProperty, boolean sortAscending) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortProperty = sortProperty;
        this.sortAscending = sortAscending;
    }

    /**
     * Поулчить номе рстраницы
     * @return Номер страницы
     */
    public int getPageNumber() {
        return pageNumber;
    }

    /**
     * Получить размер страницы
     * @return Размер страницы
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * Получить название поля сортировки
     * @return Название поля
     */
    public String getSortProperty() {
        return sortProperty;
    }

    /**
     * Получить признак сортировки по возрастанию
     * @return Признак
     */
    public boolean isSortAscending() {
        return sortAscending;
    }
}
