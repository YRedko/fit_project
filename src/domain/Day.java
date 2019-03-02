package domain;

import service.day.DayStateEnum;
import static service.day.DayStateEnum.UNDERFULFILLED;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public class Day {

    private Long id;
    private Instant date;
    private DayStateEnum status = UNDERFULFILLED;
    private User owner;
    private Long calories;
    private List<Food> food = new ArrayList<>();

    public Day() {
    }

    public Day(Long id, Instant date, DayStateEnum status, User owner, Long calories, List<Food> food) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.owner = owner;
        this.calories = calories;
        this.food = food;
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

    public DayStateEnum getStatus() {
        return status;
    }

    public void setStatus(DayStateEnum status) {
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
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}
