package dao.inmemory;

import dao.DayRepository;
import domain.Day;
import domain.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;

public class DayInMemoryRepository implements DayRepository {

    private List<Day> days = new ArrayList<>();

    private AtomicLong counter = new AtomicLong(0);

    @Override
    public Day save(Day day) {
        if(day.getId() == null){
            day.setId(counter.incrementAndGet());
        }
        days.add(day);
        return day;
    }

    @Override
    public List<Day> findDayByFood(Food food) {
        return days.stream().filter(day -> day.getFood().equals(food)).collect(toList());
    }

    @Override
    public Optional<Day> findById(Long id) {
        return days.stream().filter(day -> day.getId().equals(id)).findAny();
    }
}
