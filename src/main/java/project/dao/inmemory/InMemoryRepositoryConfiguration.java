//package project.dao.inmemory;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConditionalOnProperty(value = "application.datamode", havingValue = "inmemory")
//public class InMemoryRepositoryConfiguration {
//
//    @Bean
//    public FoodInMemoryRepository foodInMemoryRepository() {
//        return new FoodInMemoryRepository();
//    }
//
//    @Bean
//    public DayInMemoryRepository dayInMemoryRepository() {
//        return new DayInMemoryRepository();
//    }
//
//    @Bean
//    public FoodConsumptionInMemoryRepository foodConsumptionInMemoryRepository(){
//        return new FoodConsumptionInMemoryRepository();
//    }
//
//    @Bean
//    public UserInMemoryRepository userInMemoryRepository() {
//        return new UserInMemoryRepository();
//    }
//
//}
