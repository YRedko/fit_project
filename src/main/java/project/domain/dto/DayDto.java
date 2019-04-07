package project.domain.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class DayDto {
    private Instant date;
    private Long calories;
}
