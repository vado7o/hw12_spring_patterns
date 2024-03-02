package pudov.vadim.hw12_spring_patterns.dto;

import jakarta.persistence.*;

/**
 * ЭТО КЛАСС ДЛЯ ЗАДАЧ С ОБЫЧНЫМ ТИПОМ (НЕСРОЧНЫЕ). МОЖНО БЫЛО КОНЕЧНО СДЕЛАТЬ ГОРАЗДО БОЛЬШЕ УНИКАЛЬНЫХ ПОЛЕЙ,
 * НО ДЛЯ ОБРАЗЦА Я ВЗЯЛ ВСЕГО ОДНО ПОЛЕ - TYPE, ОСТАЛЬНОЕ ВСЁ НАСЛЕДУЕТСЯ ОТ РОДИТЕЛЬСКОГО КЛАССА
 */
@Entity
public class OrdinaryTask extends Task implements ITask {

    public OrdinaryTask() {
        super.setType("стандартная задача");
    }
}
