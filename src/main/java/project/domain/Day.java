package project.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode(of = "id")
public class Day {

    private Long id;
    private String date;
    //private String status = "Unfinished";
    private User owner;
    private Long calories = 0L;
    private List<FoodConsumption> eatenFood;

    public Day() {
    }

    public Day(String date, User owner, List<FoodConsumption> food) {
        this.date = date;
        //this.status = status;
        this.owner = owner;
        this.eatenFood = food;
    }
}
