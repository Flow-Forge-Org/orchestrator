package com.flow.workflow.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//  temporary file just to check the connection
@Component
public class DatabaseConnectionTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void testConnectionAndListTables() {
        try {
            String currentSchema = jdbcTemplate.queryForObject("SELECT current_schema();", String.class);
            System.out.println("✅ Database connected successfully!");
            System.out.println("Database schema: " + currentSchema);
            String sql = "SELECT table_name " +
                    "FROM information_schema.tables " +
                    "WHERE table_schema = ? " +
                    "AND table_type = 'BASE TABLE' " +
                    "ORDER BY table_name";

            List<String> tableNames = jdbcTemplate.queryForList(sql, String.class, currentSchema);

            if (tableNames.isEmpty()) {
                System.out.println("No tables found in the schema: " + currentSchema);
            } else {
                System.out.println("\nTables found in schema '" + currentSchema + "':");
                for (String tableName : tableNames) {
                    System.out.println("  - " + tableName);
                }
            }

        } catch (Exception e) {
            System.err.println("❌ Database operation failed!");
            e.printStackTrace();
        }
    }
}