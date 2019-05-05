package project.domain.dto;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;

@Data
public class DayDto {
    private LocalDate date;
    private Long calories;
}
