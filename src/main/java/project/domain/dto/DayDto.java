package project.domain.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class DayDto {
    private String date;
    private Long calories;
}
