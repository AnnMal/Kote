package ru.prgmt.warehouse.application;

import ru.prgmt.warehouse.application.result.CommandResult;
import ru.prgmt.warehouse.application.result.ErrorResult;
import ru.prgmt.warehouse.application.result.PagedResult;
import ru.prgmt.warehouse.application.result.PromptResult;

import java.util.Map;

/**
 * Точка входа в приложение
 */
public interface ApplicationController {
    /**
     * Получить все доступные команды
     * @return Словарь из названия команды и её описания
     */
    Map<String, String> getAvailableCommands();

    /**
     * Выполнить команду, применяя постраницную навигацию с сортировкой, если это применимо
     * @param name Название команды
     * @param parameters Параметры команды
     * @param paging Запрос постраничной навигации и сортировки
     * @return Результат выполнения команды
     * @see ErrorResult
     * @see PromptResult
     * @see PagedResult
     */
    CommandResult executeCommand(String name, Map<String, String> parameters, Paging paging) throws CommandNotFoundException;
}
