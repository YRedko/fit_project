package domain;

import service.day.DayStateEnum;
import static service.day.DayStateEnum.UNFINISHED;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public class Day {

    private Long id;
    private Instant date;
    private DayStateEnum status = UNFINISHED;
    private User owner;
    private List<Food> food = new ArrayList<>();

    public Day() {
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

    public List<Food> getFood() {
        return food;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }
}
