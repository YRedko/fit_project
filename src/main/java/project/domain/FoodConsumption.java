package project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString
@Entity @Table(name = "food_consumption")
public class FoodConsumption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Food food;
    private Long size;
    @ManyToOne
    @JsonIgnore
    private Day day;

    public FoodConsumption(Food food, Long size, Day day){
        this.food = food;
        this.size = size;
        this.day = day;
    }
}
