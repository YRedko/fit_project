package project.domain;

import lombok.ToString;

import java.util.Objects;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Day getDay() { return day; }

    public void setDay(Day day) { this.day = day; }

    public Long getCalories() {
        return calories;
    }

    public void setCalories(Long calories) {
        this.calories = calories;
    }

    public Long getProtein() {
        return protein;
    }

    public void setProtein(Long protein) {
        this.protein = protein;
    }

    public Long getFat() {
        return fat;
    }

    public void setFat(Long fat) {
        this.fat = fat;
    }

    public Long getCarbs() {
        return carbs;
    }

    public void setCarbs(Long carbs) {
        this.carbs = carbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(id, food.id) &&
                Objects.equals(name, food.name) &&
                Objects.equals(day, food.day) &&
                Objects.equals(calories, food.calories) &&
                Objects.equals(protein, food.protein) &&
                Objects.equals(fat, food.fat) &&
                Objects.equals(carbs, food.carbs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, calories, protein, fat, carbs);
    }
}
