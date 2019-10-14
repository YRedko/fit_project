package project.domain;

import lombok.*;

import javax.persistence.*;


@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Entity @Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
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

    public Food(String name, Long calories, Long protein, Long fat, Long carbs){
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

}
