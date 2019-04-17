package project.dao.inmemory;

import org.springframework.stereotype.Repository;
import project.dao.FoodConsumptionRepository;
import project.domain.FoodConsumption;
import project.domain.User;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class FoodConsumptionInMemoryRepository implements FoodConsumptionRepository {

    List<FoodConsumption> foodConsumptions = new ArrayList<>();

    private AtomicLong counter = new AtomicLong(0);

    @Override
    public FoodConsumption save(FoodConsumption foodConsumption) {
        foodConsumption.setId(counter.incrementAndGet());
        foodConsumptions.add(foodConsumption);
        return foodConsumption;
    }

    @Override
    public List<FoodConsumption> findByDateAndUser(String date, User user) {
        List<FoodConsumption> list = new ArrayList<>();
        for (FoodConsumption foodConsumption : foodConsumptions) {
            if (foodConsumption.getDay().getDate().equals(date) &&
                    foodConsumption.getDay().getOwner().equals(user)) {
                list.add(foodConsumption);
            }
        }
        return list;
    }

    @Override
    public void delete(Long id) {
        foodConsumptions.removeIf(foodConsumption -> foodConsumption.getId().equals(id));
    }
}
