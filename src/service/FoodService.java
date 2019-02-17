package service;

import dao.FoodRepository;
import domain.Food;

public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    //public Food addFood()
}
