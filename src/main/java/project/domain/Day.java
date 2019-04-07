package project.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Day {

    private Long id;
    private Instant date;
    private String status = "Unfinished";
    private User owner;
    private Long calories;
    private FoodConsumption eatenFood;
    //private List<Food> eatenFood = new ArrayList<>();

    public Day() {
    }

    public Day(Instant date, String status, User owner, Long calories, FoodConsumption food) {
        this.date = date;
        this.status = status;
        this.owner = owner;
        this.calories = calories;
        this.eatenFood = food;
    }
}
