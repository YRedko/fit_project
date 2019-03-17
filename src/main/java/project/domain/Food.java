package project.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Food {

    private Long id;
    private String name;
    private Day day;
    private Long calories;
    private Long protein;
    private Long fat;
    private Long carbs;

    public Food(long id, String name, Long calories, Long protein, Long fat, Long carbs) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

    public Food(){}

}
