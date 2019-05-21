/*
package project.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConnectionManager {

    private final DataSourceProperties properties;

    @PostConstruct
    @SneakyThrows
    public void init() {
        Class.forName(properties.getDriverClassName());
    }

    @SneakyThrows
    protected Connection createConnection() {
        return DriverManager.getConnection(properties.getUrl(),
                properties.getUsername(),
                properties.getPassword());
    }

}*/
