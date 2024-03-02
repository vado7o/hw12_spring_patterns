package pudov.vadim.hw12_spring_patterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pudov.vadim.hw12_spring_patterns.dto.ITask;
import pudov.vadim.hw12_spring_patterns.dto.Task;
import pudov.vadim.hw12_spring_patterns.factory.TaskFactory;
import pudov.vadim.hw12_spring_patterns.service.TaskService;

import java.util.List;


/**
 * КОНТРОЛЛЕР ДЛЯ РАБОТЫ С ПРИЛОЖЕНИЕМ ЧЕРЕЗ SPRING WEB. НАЗНАЧЕНИЕ МЕТОДОВ ОПИСАНО В ИНТЕРФЕЙСЕ TaskController
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskControllerImpl implements TaskController {
    private final TaskService service;
    private final TaskFactory factory;

    @Autowired
    public TaskControllerImpl(TaskService service, TaskFactory factory) {
        this.service = service;
        this.factory = factory;
    }

    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks() { return ResponseEntity.ok(service.getAllTasks()); }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) { return ResponseEntity.ok(service.getTaskById(id)); }

    @PostMapping("/create")
    public ResponseEntity<ITask> createTask(@RequestParam String description,
                                            @RequestParam String holderName,
                                            @RequestParam String date) {
        return ResponseEntity.ok(factory.createTask(description, holderName, date));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) { service.deleteTask(id); }

    @PostMapping("/update/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,
                                           @RequestParam String description,
                                           @RequestParam String holderName) {
        return ResponseEntity.ok(service.updateTask(id, description, holderName));
    }
}
