package project.dao.jdbc;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import project.dao.DayRepository;
import project.domain.Day;
import project.domain.User;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class JdbcDayRepository implements DayRepository {

    private final ConnectionManager connectionManager;

    @Override
    @SneakyThrows
    public Day save(Day day) {
        try (Connection connection = connectionManager.createConnection()){
            connection.setAutoCommit(false);
            try{
                if(day.getId() == null){
                    try(PreparedStatement statement = connection.prepareStatement("INSERT INTO day (calories, date, owner_login) value (?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS)){
                        statement.setLong(1, day.getCalories());
                        statement.setDate(2, Date.valueOf(day.getDate()));
                        statement.setString(3, day.getOwner().getLogin());
                        if(statement.getGeneratedKeys().next()){
                            day.setId(statement.getGeneratedKeys().getLong("id"));
                        }
                    }
                }else {
                    try(PreparedStatement statement = connection.prepareStatement("UPDATE day SET calories=?, date=? WHERE id=? ")){
                        statement.setLong(1, day.getCalories());
                        statement.setDate(2, Date.valueOf(day.getDate()));
                        statement.setLong(5, day.getId());
                        statement.executeUpdate();
                    }
                }
                connection.commit();
            } catch (Exception e){
                log.error("Error safe day: ", e);
                connection.rollback();
                throw e;
            }
        }
        return day;
    }

    @Override
    @SneakyThrows
    public List<Day> findAll() {
        List<Day> days = new ArrayList<>();
        try(Connection connection = connectionManager.createConnection()) {
            PreparedStatement dayStatement = connection.prepareStatement("SELECT * FROM day");
            ResultSet dayResultSet = dayStatement.executeQuery();
            while (dayResultSet.next()){
                Day day = new Day();
                day.setId(dayResultSet.getLong("id"));
                day.setDate(dayResultSet.getDate("date").toLocalDate());
                day.setCalories(dayResultSet.getLong("calories"));
                days.add(day);
            }
        }
        return days;
    }

//    @Override
//    @SneakyThrows
//    public List<Day> findDayByFoodAndUser(Food food, User user) {
//        List<Day> days = new ArrayList<>();
//        try(Connection connection = connectionManager.createConnection()) {
//            PreparedStatement dayStatement = connection.prepareStatement("SELECT * FROM day WHERE ");
//            ResultSet dayResultSet = dayStatement.executeQuery();
//            while (dayResultSet.next()){
//                Day day = new Day();
//                day.setId(dayResultSet.getLong("id"));
//                day.setDate(dayResultSet.getDate("date").toLocalDate());
//                day.setCalories(dayResultSet.getLong("calories"));
//                days.add(day);
//            }
//        }
//        return days;
//    }

    @Override
    @SneakyThrows
    public List<Day> findDayByUser(User user) {
        List<Day> days = new ArrayList<>();
        try(Connection connection = connectionManager.createConnection()) {
            PreparedStatement dayStatement = connection.prepareStatement("SELECT * FROM day WHERE owner_login=?");
            dayStatement.setString(1, user.getLogin());
            ResultSet dayResultSet = dayStatement.executeQuery();
            while (dayResultSet.next()){
                Day day = new Day();
                day.setId(dayResultSet.getLong("id"));
                day.setDate(dayResultSet.getDate("date").toLocalDate());
                day.setCalories(dayResultSet.getLong("calories"));
                days.add(day);
            }
        }
        return days;
    }

    @Override
    @SneakyThrows
    public Optional<Day> findDayByDate(LocalDate date) {
        try(Connection connection = connectionManager.createConnection()) {
            PreparedStatement dayStatement = connection.prepareStatement("SELECT * FROM day WHERE date=?");
            dayStatement.setDate(1, Date.valueOf(date));
            ResultSet dayResultSet = dayStatement.executeQuery();
            while (dayResultSet.next()){
                Day day = new Day();
                day.setId(dayResultSet.getLong("id"));
                day.setDate(dayResultSet.getDate("date").toLocalDate());
                day.setCalories(dayResultSet.getLong("calories"));
                return Optional.of(day);
            }
        }
        return Optional.empty();
    }

    @Override
    @SneakyThrows
    public Optional<Day> findById(Long id) {
        try(Connection connection = connectionManager.createConnection()) {
            PreparedStatement dayStatement = connection.prepareStatement("SELECT * FROM day WHERE id=?");
            dayStatement.setLong(1, id);
            ResultSet dayResultSet = dayStatement.executeQuery();
            while (dayResultSet.next()){
                Day day = new Day();
                day.setId(dayResultSet.getLong("id"));
                day.setDate(dayResultSet.getDate("date").toLocalDate());
                day.setCalories(dayResultSet.getLong("calories"));
                return Optional.of(day);
            }
        }
        return Optional.empty();
    }
}
