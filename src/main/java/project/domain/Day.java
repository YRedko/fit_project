package project.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = "eatenFood")
@Entity @Table(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    //private String status = "Unfinished";
    @ManyToOne
    private User owner;
    private Long calories = 0L;
    @OneToMany(mappedBy = "day")
    private List<FoodConsumption> eatenFood;

    public Day() {
    }

    public Day(LocalDate date, User owner) {
        this.date = date;
        this.owner = owner;
    }

    public Day(LocalDate date, User owner, List<FoodConsumption> food) {
        this.date = date;
        //this.status = status;
        this.owner = owner;
        this.eatenFood = food;
    }

//    @JsonProperty
//    public String getSmtn() {
//        return "werwerer";
//    }
}
