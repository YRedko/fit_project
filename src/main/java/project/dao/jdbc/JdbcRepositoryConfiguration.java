//package project.dao.jdbc;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import project.dao.inmemory.UserInMemoryRepository;
//
//@Configuration
//@ConditionalOnProperty(value = "application.datamode", havingValue = "jdbc")
//public class JdbcRepositoryConfiguration {
//
////    @Bean
//////    public JdbcCommentRepository jdbcCommentRepository(ConnectionManager connectionManager, ProductRepository productRepository) {
//////        return new JdbcCommentRepository(connectionManager, productRepository);
//////    }
//
////    @Bean
////    public JdbcFoodConsumptionRepository jdbcFoodConsumptionRepository(ConnectionManager connectionManager) {
////        return new JdbcFoodConsumptionRepository(connectionManager);
////    }
//
//    @Bean
//    public JdbcFoodRepository jdbcFoodRepository(ConnectionManager connectionManager){
//        return new JdbcFoodRepository(connectionManager);
//    }
//
//    @Bean
//    public JdbcUserRepository jdbcUserRepository(ConnectionManager connectionManager){
//        return new JdbcUserRepository(connectionManager);
//    }
//
////    @Bean
////    public UserInMemoryRepository userInMemoryRepository() {
////        return new UserInMemoryRepository();
////    }
//
//}
