package pudov.vadim.hw12_spring_patterns.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pudov.vadim.hw12_spring_patterns.dto.ITask;
import pudov.vadim.hw12_spring_patterns.dto.OrdinaryTask;
import pudov.vadim.hw12_spring_patterns.dto.Task;
import pudov.vadim.hw12_spring_patterns.dto.UrgentTask;
import pudov.vadim.hw12_spring_patterns.service.TaskRepo;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * ФАБРИКА ДЛЯ СОЗДАНИЯ ЗАДАЧ. МЕТОД createTask АНАЛИЗИРУЕТ ОСТАВШЕЕСЯ ВРЕМЯ ДО ЗАВЕРШЕНИЯ СРОКА ЗАДАЧИ (НАЧИНАЯ
 * ОТ СЕГОДНЯШНЕЙ ДАТЫ, И, ЕСЛИ ОСТАЛОСЬ МЕНЕЕ 30 ДНЕЙ, ТО СОЗДАЁТСЯ КЛАСС UrgentTask.class (задачи срочного типа),
 * ИНАЧЕ СОЗДАЁТСЯ КЛАСС Ordinary.class (задачи обычного типа).
 */
@Service
public class TaskFactory implements ITaskFactory {
    @Autowired
    private TaskRepo taskRepo;

    @Override
    public ITask createTask(String description, String holderName, String date) {
        Task task;
        LocalDate taskDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yy"));

        System.out.println(Duration.between(taskDate.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays());
        if (Duration.between(LocalDate.now().atStartOfDay(), taskDate.atStartOfDay()).toDays() < 30) task = new UrgentTask();
        else task = new OrdinaryTask();

        task.setDescription(description);
        task.setHolderName(holderName);
        task.setDate(taskDate);

        return taskRepo.save(task);
    }
}
