package com.gift.jdbc.sandbox

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

public class SandboxEnvironment {

    private static final Logger LOGGER = LoggerFactory.getLogger(SandboxEnvironment.class)

    private static EmbeddedDatabase database
    private static JdbcTemplate jdbcTemplate

    public static EmbeddedDatabase getDatabase() {
        return database
    }

    public static JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate
    }

    public static void createSandbox(List<String> tables) {
        database = new EmbeddedDatabaseBuilder()
                .addScripts((String[]) tables.toArray())
                .build()
        jdbcTemplate = new JdbcTemplate(database)
        LOGGER.info("Database created successfully...");
    }

    public static void createSandbox(Class<?> table) {
        LOGGER.info("Creating Tables..");
        List<String> tables = new ArrayList<>();
        table.each {
            LOGGER.debug("Creating Tables.." + it);
            tables.add("classpath:" + it + ".sql");
            tables.add("classpath:" + it + "-data.sql");
        }
        createSandbox(tables)
    }

    public static void createSandbox(Class<?> table, Class<?> data) {
        List<String> tables = new ArrayList<>();
        table.each {
            tables.add("classpath:" + it + ".sql");
        }
        data.each {
            tables.add("classpath:" + it + "-data.sql");
        }
        createSandbox(tables)
    }
}
