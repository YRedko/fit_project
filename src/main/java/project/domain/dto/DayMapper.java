package project.domain.dto;

import org.mapstruct.Mapper;
import project.domain.Day;

@Mapper(componentModel = "spring")
public interface DayMapper {
    Day toDay(DayDto dayDto);
}
