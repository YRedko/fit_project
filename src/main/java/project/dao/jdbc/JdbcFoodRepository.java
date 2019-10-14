//package project.dao.jdbc;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import project.dao.FoodRepository;
//import project.domain.Food;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@RequiredArgsConstructor
//public class JdbcFoodRepository implements FoodRepository {
//
//    private final ConnectionManager connectionManager;
//
//    @Override
//    @SneakyThrows
//    public Food save(Food food) {
//        try (Connection connection = connectionManager.createConnection()){
//            connection.setAutoCommit(false);
//            try{
//                if(food.getId() == null){
//                    try(Statement statement = connection.createStatement()){
//                        statement.executeUpdate(String.format("INSERT INTO food (name, calories, protein, fat, carbs) " +
//                                "VALUES ('%s', '%s', '%s', '%s', '%s')", food.getName(), food.getCalories(), food.getProtein(),
//                                food.getFat(), food.getCarbs()), Statement.RETURN_GENERATED_KEYS);
//                        if(statement.getGeneratedKeys().next()){
//                            food.setId(statement.getGeneratedKeys().getLong("id"));
//                        }
//                    }
//                }else {
//                    try(PreparedStatement statement = connection.prepareStatement("UPDATE food SET calories=?, protein=?, fat=?, carbs=? WHERE id=? ")){
//                        statement.setLong(1, food.getCalories());
//                        statement.setLong(2, food.getProtein());
//                        statement.setLong(3, food.getFat());
//                        statement.setLong(4, food.getCarbs());
//                        statement.setLong(5, food.getId());
//                        statement.executeUpdate();
//                    }
//                }
//                connection.commit();
//            } catch (Exception e){
//                log.error("Error safe food: ", e);
//                connection.rollback();
//                throw e;
//            }
//        }
//        return food;
//    }
//
//    @Override
//    @SneakyThrows
//    public List<Food> findAll() {
//        List<Food> foods = new ArrayList<>();
//        try(Connection connection = connectionManager.createConnection()){
//            PreparedStatement foodStatement = connection.prepareStatement("SELECT * FROM food");
//            ResultSet foodResultSet = foodStatement.executeQuery();
//            while (foodResultSet.next()){
//                Food food = new Food();
//                food.setId(foodResultSet.getLong("id"));
//                food.setName(foodResultSet.getString("name"));
//                food.setCalories(foodResultSet.getLong("calories"));
//                food.setProtein(foodResultSet.getLong("protein"));
//                food.setFat(foodResultSet.getLong("fat"));
//                food.setCarbs(foodResultSet.getLong("carbs"));
//                foods.add(food);
//            }
//        }
//        return foods;
//    }
//
//    @Override
//    @SneakyThrows
//    public List<Food> findByName(String name) {
//        List<Food> foods = new ArrayList<>();
//        try(Connection connection = connectionManager.createConnection()){
//            PreparedStatement foodStatement = connection.prepareStatement("SELECT * FROM food WHERE name=?");
//            foodStatement.setString(1, name);
//            ResultSet foodResultSet = foodStatement.executeQuery();
//            while (foodResultSet.next()){
//                Food food = new Food();
//                food.setId(foodResultSet.getLong("food.id"));
//                food.setName(foodResultSet.getString("food.name"));
//                food.setCalories(foodResultSet.getLong("food.calories"));
//                food.setProtein(foodResultSet.getLong("food.protein"));
//                food.setFat(foodResultSet.getLong("food.fat"));
//                food.setCarbs(foodResultSet.getLong("food.carbs"));
//                foods.add(food);
//            }
//        }
//        return foods;
//    }
//
//    @Override
//    @SneakyThrows
//    public Optional<Food> findById(Long id) {
//        try(Connection connection = connectionManager.createConnection()) {
//            PreparedStatement foodStatement = connection.prepareStatement(
//                    "SELECT * FROM food WHERE id = ?"
//            );
//            foodStatement.setLong(1, id);
//            ResultSet foodResultSet = foodStatement.executeQuery();
//            while (foodResultSet.next()){
//                Food food = new Food();
//                food.setId(foodResultSet.getLong("food.id"));
//                food.setName(foodResultSet.getString("food.name"));
//                food.setCalories(foodResultSet.getLong("food.calories"));
//                food.setProtein(foodResultSet.getLong("food.protein"));
//                food.setFat(foodResultSet.getLong("food.fat"));
//                food.setCarbs(foodResultSet.getLong("food.carbs"));
//                return Optional.of(food);
//            }
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    @SneakyThrows
//    public void delete(Long id) {
//        try(Connection connection = connectionManager.createConnection()){
//            connection.setAutoCommit(false);
//            try{
//                PreparedStatement statement = connection.prepareStatement("DELETE FROM food WHERE id=?");
//                statement.setLong(1, id);
//                statement.executeUpdate();
//                connection.commit();
//            }catch(Exception e){
//                log.error("Error deletion food: ", e);
//                connection.rollback();
//                throw e;
//            }
//        }
//    }
//}
//
