package com.glearning.empcrud.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
//@ComponentScan("com.glearning.empcrud")
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.glearning.empcrud.repository",
  //          transactionManagerRef = "txManager",
    //        entityManagerFactoryRef = "emf")

public class AppConfig {

    /*
        <bean id="datasource" class="org.apache.commons.dbcp2.BasicDataSource">
          <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
          <property name="username" value="root"/>
          <property name="password" value="welcome"/>
          <property name="url" value="jdbc:mysql://localhost:3306/emp_db"/>
        </bean>
     */
    @Bean
    DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("welcome");
        dataSource.setUrl("jdbc:mysql://localhost:3306/emp_db");
        return dataSource;
    }

    /*
         <bean id="emf"
             class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">

            <property name="packagesToScan" value="com.glearning.empcrud.model" />

            <property name="dataSource" ref="datasource" />

            <property name="jpaProperties">
                <props>
                    <prop key="hibernate.show_sql">true</prop>
                    <prop key="hibernate.format_sql">true</prop>
                    <prop key="hibernate.hbm2ddl.auto">create</prop>
                    <prop key="hibernate.dialect">org.hibernate.dialect.MySQL57Dialect</prop>
                </props>
            </property>

            <property name="persistenceProvider">
                <bean class="org.hibernate.jpa.HibernatePersistenceProvider"></bean>
            </property>

        </bean>
     */
    @Bean(name = "emf")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.glearning.empcrud.model"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean(value = "txManager")
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.format_sql", "true");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");

        return properties;
    }

    /*@Bean
    public ViewResolver getViewResovler() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();        urlBasedViewResolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }*/
}