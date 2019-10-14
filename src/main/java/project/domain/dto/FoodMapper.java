package project.domain.dto;

import org.mapstruct.Mapper;
import project.domain.Food;

@Mapper(componentModel = "spring")
public interface FoodMapper {
    Food toFood(FoodDto foodDto);
}
