package pudov.vadim.hw12_spring_patterns.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pudov.vadim.hw12_spring_patterns.dto.Task;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
