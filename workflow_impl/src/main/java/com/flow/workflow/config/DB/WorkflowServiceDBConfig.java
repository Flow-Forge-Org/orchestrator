package com.flow.workflow.config.DB;

import com.flowForge.config.FlowDBConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.flow.workflow.repository",
        entityManagerFactoryRef = "workflowEntityManagerFactory",
        transactionManagerRef = "workflowTransactionManager"
)
// TODO: Make this programmatic.
public class WorkflowServiceDBConfig extends FlowDBConfig {

    Envi

    @Bean
    @Primary
    @Override
    public DataSource getDataSource() {
        return null;
    }

    @Bean(name = "workflowEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean workflowEntityManagerFactory(){

    }

    @Bean(name = "workflowTransactionManager")
    @Primary
    public PlatformTransactionManager workflowTransactionManager(){

    }

}
