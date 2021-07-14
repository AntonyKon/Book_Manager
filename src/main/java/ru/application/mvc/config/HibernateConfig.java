package ru.application.mvc.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan("ru.application.mvc")
@PropertySource("classpath:connection.properties")
@EnableTransactionManagement
public class HibernateConfig implements TransactionManagementConfigurer {
    private final String url;
    private final String username;
    private final String password;
    private final String driver;

    public HibernateConfig(@Value("${connection.url}") String url,
                           @Value("${connection.username}") String username,
                           @Value("${connection.password}") String password,
                           @Value("${connection.driver}") String driver) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }
    
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactoryBean() throws PropertyVetoException, IOException {
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("ru.application.mvc.models");

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        localSessionFactoryBean.setHibernateProperties(properties);

        localSessionFactoryBean.afterPropertiesSet();

        return localSessionFactoryBean.getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager() throws PropertyVetoException, IOException {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactoryBean());

        return transactionManager;
    }

    @Override
    public TransactionManager annotationDrivenTransactionManager() {
        try {
            return transactionManager();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
