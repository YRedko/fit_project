package project.domain;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public class Day {

    private Long id;
    private Instant date;
    private String status = "Unfinished";
    private User owner;
    private Long calories;
    private List<Food> eatenFood = new ArrayList<>();

    public Day() {
    }

    public Day(Instant date, String status, User owner, Long calories, List<Food> food) {
        this.date = date;
        this.status = status;
        this.owner = owner;
        this.calories = calories;
        this.eatenFood = food;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public List<Food> getFood() {
        return eatenFood;
    }

    public void setFood(List<Food> food) {
        this.eatenFood = food;
    }
}
