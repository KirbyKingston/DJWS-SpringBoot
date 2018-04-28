package data;

import java.util.Properties;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Mitch
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "DJWS-SpringBoot")
public class PersistenceJDBCConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
            throws NamingException {
        LocalContainerEntityManagerFactoryBean emf
                = new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(dataSource());
        emf.setPackagesToScan("DJWS-SpringBoot.src.main.java");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.DerbyDialect");
        properties.setProperty("hibernate.show_sql", "true");

        emf.setJpaProperties(properties);
        emf.afterPropertiesSet();

        return emf;
    }

    @Bean
    public DataSource dataSource() throws NamingException {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
        datasource.setUrl("jdbc:derby://localhost:1527/StoreData");
        datasource.setUsername("MAF");
        datasource.setPassword("APP");
        return datasource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

}
