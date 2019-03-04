package project.domain;

public class FoodDto {

    private Long id;
    private Long size;

    public FoodDto(){
    }

    public FoodDto(Long id, Long size) {
        this.id = id;
        this.size = size;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}
