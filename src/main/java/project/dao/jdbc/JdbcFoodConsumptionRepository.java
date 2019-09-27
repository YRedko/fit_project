//package project.dao.jdbc;
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import project.dao.FoodConsumptionRepository;
//import project.domain.Food;
//import project.domain.FoodConsumption;
//import project.domain.User;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@RequiredArgsConstructor
//public class JdbcFoodConsumptionRepository implements FoodConsumptionRepository {
//
//    private final ConnectionManager connectionManager;
//
//    @Override
//    @SneakyThrows
//    public FoodConsumption save(FoodConsumption foodConsumption) {
//        try (Connection connection = connectionManager.createConnection()){
//            connection.setAutoCommit(false);
//            try{
//                if(foodConsumption.getId() == null){
//                    try(Statement statement = connection.createStatement()){
//                        statement.executeUpdate(String.format("INSERT INTO foodConsumption (food_id, size, day_id) " +
//                                        "VALUES ('%s', '%s', '%s')", foodConsumption.getFood(), foodConsumption.getSize(),
//                                foodConsumption.getDay(), Statement.RETURN_GENERATED_KEYS));
//                        if(statement.getGeneratedKeys().next()){
//                            foodConsumption.setId(statement.getGeneratedKeys().getLong("id"));
//                        }
//                    }
//                }else {
//                    try(PreparedStatement statement = connection.prepareStatement("UPDATE foodConsumption SET size_=? WHERE id=? ")){
//                        statement.setLong(1, foodConsumption.getSize());
//                        statement.setLong(2, foodConsumption.getId());
//                        statement.executeUpdate();
//                    }
//                }
//            } catch (Exception e){
//                log.error("Error safe food consumption", e);
//                connection.rollback();
//                throw e;
//            }
//        }
//        return foodConsumption;
//    }
//
//    @Override
//    @SneakyThrows
//    public List<FoodConsumption> findAll() {
//        List<FoodConsumption> foodConsumptions = new ArrayList<>();
//        try(Connection connection = connectionManager.createConnection()){
//            PreparedStatement foodStatement = connection.prepareStatement("SELECT * FROM food");
//            ResultSet foodConsumptionResultSet = foodStatement.executeQuery();
//            while (foodConsumptionResultSet.next()){
//                FoodConsumption foodConsumption = new FoodConsumption();
//                foodConsumption.setId(foodConsumptionResultSet.getLong("foodConsumption.id"));
//                foodConsumption.setFood(getFoodById(foodConsumptionResultSet.getLong("foodConsumption.id"), connection));
//                foodConsumption.setSize(foodConsumptionResultSet.getLong("foodConsumption.size"));
//                foodConsumptions.add(foodConsumption);
//            }
//        }
//        return foodConsumptions;
//    }
//
//    @Override
//    @SneakyThrows
//    public List<FoodConsumption> findByDateAndUser(LocalDate date, User user) {
//        return null;
//    }
//
//    @Override
//    @SneakyThrows
//    public Optional<FoodConsumption> findById(Long id) {
//        try (Connection connection = connectionManager.createConnection()) {
//            PreparedStatement foodConsumptionStatement = connection.prepareStatement(
//                    "SELECT *, owner.login as ownerlogin, owner.password_hash as ownerpassword_hash," +
//                            "  buyer.login as buyerlogin, buyer.password_hash as buyerpassword_hash" +
//                            " FROM product" +
//                            " inner join user AS owner on owner.login = product.owner_login" +
//                            " left join user AS buyer ON buyer.login = product.buyer_login" +
//                            " WHERE id = ?");
//            foodConsumptionStatement.setLong(1, id);
//            ResultSet foodConsumptionResultSet = foodConsumptionStatement.executeQuery();
//            while (foodConsumptionResultSet.next()) {
//                FoodConsumption foodConsumption = new FoodConsumption();
//                foodConsumption.setId(foodConsumptionResultSet.getLong("foodConsumption.id"));
//                foodConsumption.setFood(getFoodById(foodConsumptionResultSet.getLong("foodConsumption.id"), connection));
//                foodConsumption.setSize(foodConsumptionResultSet.getLong("foodConsumption.size"));
//                foodConsumption.setOwner(new User(foodConsumptionResultSet.getString("ownerlogin"),
//                        foodConsumptionResultSet.getString("ownerpassword_hash")));
//                if (foodConsumptionResultSet.getString("buyerlogin") != null) {
//                    foodConsumption.setBuyer(new User(foodConsumptionResultSet.getString("buyerlogin"),
//                            foodConsumptionResultSet.getString("buyerpassword_hash")));
//                }
//                return Optional.of(foodConsumption);
//            }
//        }
//        return Optional.empty();
//    }
//
//    @SneakyThrows
//    private Food getFoodById(Long id, Connection connection) {
//        PreparedStatement statement = connection.prepareStatement("SELECT * FROM bid WHERE product_id = ?");
//        statement.setLong(1, id);
//        ResultSet resultSet = statement.executeQuery();
//        List<Bid> bids = new ArrayList<>();
//        while (resultSet.next()) {
//            Bid bid = new Bid();
//            bid.setId(resultSet.getLong("id"));
//            bid.setAmount(resultSet.getInt("amount"));
//            bids.add(bid);
//        }
//        return bids;
//    }
//
//    @Override
//    @SneakyThrows
//    public void delete(Long id) {
//
//    }
//}
