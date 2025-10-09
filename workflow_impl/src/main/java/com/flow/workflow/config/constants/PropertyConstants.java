package com.flow.workflow.config.constants;

public interface PropertyConstants {
    String JDBC_URL_KEY = "workflow.datasource.url";
    String USER_NAME_KEY = "workflow.datasource.username";
    String PASSWORD_KEY = "workflow.datasource.password";
    String DRIVER_CLASS_NAME_KEY = "workflow.datasource.driver-class-name";

    String JPA_DDL_AUTO_KEY = "jpa.hibernate.ddl-auto";
    String JPA_SHOW_SQL_KEY = "jpa.show-sql";
    String JPA_HIBERNATE_FORMAT_SQL_KEY = "jpa.properties.hibernate.format_sql";
    String JPA_DATABASE_PLATFORM_KEY = "jpa.database-platform";

    String HIBERNATE_DDL_AUTO_KEY = "hibernate.hbm2ddl.auto";
    String HIBERNATE_DIALECT_KEY = "hibernate.dialect";
}
