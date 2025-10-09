package com.flow.workflow.config.jpa;

import com.flowForge.config.FlowDBConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

import java.util.Properties;

import static com.flow.workflow.config.constants.PropertyConstants.*;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.flow.workflow.repository.*",
        entityManagerFactoryRef = "workflowEntityManagerFactory",
        transactionManagerRef = "workflowTransactionManager"
)
// TODO: Do this configuration using methods.
public class WorkflowServiceDBConfig extends FlowDBConfig {

    public static final String ENTITY_PACKAGES = "com.flow.workflow.*";
    public static final String WORKFLOW_PERSISTENCE_UNIT = "workflowPersistenceUnit";
    private final Environment env;

    public WorkflowServiceDBConfig(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    @Override
    public DataSource getDataSource() {
        // TODO: Make this automatic such that just declaring the properties should auto configure them.
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(env.getProperty(JDBC_URL_KEY));
        dataSource.setUsername(env.getProperty(USER_NAME_KEY));
        dataSource.setPassword(env.getProperty(PASSWORD_KEY));
        dataSource.setDriverClassName(env.getProperty(DRIVER_CLASS_NAME_KEY));
        return dataSource;
    }

    @Bean(name = "workflowEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean workflowEntityManagerFactory() {
        Properties jpaProperties = new Properties();
        jpaProperties.put(HIBERNATE_DDL_AUTO_KEY,env.getProperty(JPA_DDL_AUTO_KEY));
        jpaProperties.put(HIBERNATE_DIALECT_KEY,env.getProperty(JPA_DATABASE_PLATFORM_KEY));
        jpaProperties.put(JPA_SHOW_SQL_KEY, env.getProperty(JPA_SHOW_SQL_KEY));
        jpaProperties.put(JPA_HIBERNATE_FORMAT_SQL_KEY,env.getProperty(JPA_HIBERNATE_FORMAT_SQL_KEY));

        return createEntityManagerFactory(
                getDataSource(),
                WORKFLOW_PERSISTENCE_UNIT,
                new String[]{ENTITY_PACKAGES},
                jpaProperties
        );
    }

    @Bean(name = "workflowTransactionManager")
    @Primary
    public PlatformTransactionManager workflowTransactionManager() {
        return createTransactionManager(workflowEntityManagerFactory());
    }

}
