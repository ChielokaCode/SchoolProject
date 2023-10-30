package org.school.schoolproject.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Data
public class Classes {
    private String className;
    private LocalTime classStartTime;
    private LocalTime classStopTime;


}
