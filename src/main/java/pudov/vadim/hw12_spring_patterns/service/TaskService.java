package pudov.vadim.hw12_spring_patterns.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pudov.vadim.hw12_spring_patterns.dto.Task;

import java.util.List;


@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> getAllTasks() { return taskRepo.findAll(); }

    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElseThrow(() -> new RuntimeException("Задача не найдена!"));
    }

    public Task updateTask(Long id, String description, String holderName) {
        Task existingTask = getTaskById(id);
        existingTask.setDescription(description);
        existingTask.setHolderName(holderName);

        return taskRepo.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepo.delete(getTaskById(id));
    }

}
