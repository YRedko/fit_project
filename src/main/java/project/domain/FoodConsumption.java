package project.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class FoodConsumption {
    private Long id;
    private Food food;
    private Long size;
    private Day day;

    public FoodConsumption(Food food, Long size, Day day){
        this.food = food;
        this.size = size;
        this.day = day;
    }
}
