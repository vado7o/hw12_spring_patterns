package pudov.vadim.hw12_spring_patterns.dto;

import java.time.LocalDate;

public interface ITask {
    public Long getTaskId();

    public void setTaskId(Long id);

    public String getDescription();

    public void setDescription(String description);

    public LocalDate getDate();

    public void setDate(LocalDate date);

    public String getHolderName();

    public void setHolderName(String holderName);

    public String getType();

    public void setType(String type);
}
