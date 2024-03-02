package pudov.vadim.hw12_spring_patterns.controller;


import org.springframework.http.ResponseEntity;
import pudov.vadim.hw12_spring_patterns.dto.ITask;
import pudov.vadim.hw12_spring_patterns.dto.Task;

import java.util.List;

public interface TaskController {

    public ResponseEntity<Task> getTask(Long id);  // метод для изъятия задачи по айдишнику=id

    public ResponseEntity<List<Task>> getAllTasks();  // метод для изъятия из БД всех задач

    public ResponseEntity<ITask> createTask(String date, String description, String responsibilityName); // метод для создания задачи

    public ResponseEntity<Task> updateTask(Long id, String description, String holderName); // метод для изменения задачи

    public void deleteTask(Long id); // метод для удаления задачи
}
