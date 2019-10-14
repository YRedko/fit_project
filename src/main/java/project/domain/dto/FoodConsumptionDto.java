package project.domain.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FoodConsumptionDto {
    private Long foodId;
    private Long size;
    private Long dayId;
}
