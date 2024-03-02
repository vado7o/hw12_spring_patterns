package pudov.vadim.hw12_spring_patterns.dto;

import jakarta.persistence.*;

import java.time.LocalDate;

/**
 * КЛАСС ЗАДАЧ.
 */
@Entity
public class Task implements ITask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String holderName;
    @Column(nullable = false)
    private String type;

    public Task() {
        // Nothing to do
    }

    public Task(Long taskId, String description, LocalDate date, String holderName) {
        this.taskId = taskId;
        this.description = description;
        this.date = date;
        this.holderName = holderName;
    }

    @Override
    public Long getTaskId() { return taskId; }

    @Override
    public void setTaskId(Long taskId) { this.taskId = taskId; }

    @Override
    public String getDescription() { return description; }

    @Override
    public void setDescription(String description) { this.description = description; }

    @Override
    public LocalDate getDate() { return date; }

    @Override
    public void setDate(LocalDate date) { this.date = date; }

    @Override
    public String getHolderName() { return holderName; }

    @Override
    public void setHolderName(String holderName) { this.holderName = holderName; }

    @Override
    public String getType() { return type; }

    @Override
    public void setType(String type) { this.type = type; }
}
