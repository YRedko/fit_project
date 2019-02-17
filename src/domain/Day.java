package domain;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

public class Day {
    private Long id;
    private Instant date;
    private List<Food> food = new ArrayList<>();
}
