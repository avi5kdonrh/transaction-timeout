package org.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Duration;
import java.util.UUID;

@RequestMapping("/")
@RestController
public class DBController {
    @Autowired
    DataSource dataSource;

    @GetMapping(path = "/jdbc-test", produces = "text/plain; charset=utf-8")
    @Transactional
    public String testTransaction()
            throws Exception {
        try {
            insertOperation("test");
            Thread.sleep(Duration.ofSeconds(6).toMillis());
            insertOperation("customers");
        } catch (Exception exception) {
            throw exception;
        }
        return "OK";
    }
    private void insertOperation(String tableName) throws Exception{
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement =
                         connection.prepareStatement("insert into "+tableName+" (val) values (?)")) {
                statement.setString(1, UUID.randomUUID().toString());
                statement.execute();
            }
        }
    }

}
