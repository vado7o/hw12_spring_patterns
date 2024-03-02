package pudov.vadim.hw12_spring_patterns.factory;

import pudov.vadim.hw12_spring_patterns.dto.ITask;

/**
 * ИНТЕРФЕЙС ФАБРИКИ ДЛЯ СОЗДАНИЯ ЗАДАЧ. СОДЕРЖИТ МЕТОД ДЛЯ СОЗДАНИЯ ЗАДАЧ
 */
public interface ITaskFactory {
    ITask createTask(String description, String holderName, String date);
}
