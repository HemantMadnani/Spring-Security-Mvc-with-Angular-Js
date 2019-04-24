package co.in.springsecwithhib.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.in.springsecwithhib.model.Authority;
import co.in.springsecwithhib.model.Role;
import co.in.springsecwithhib.model.User;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = "co.in.springsecwithhib.config")
public class RootConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {

		final BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(environment.getProperty("db.driver"));
		basicDataSource.setUrl(environment.getProperty("db.url"));
		basicDataSource.setUsername(environment.getProperty("db.username"));
		basicDataSource.setPassword(environment.getProperty("db.password"));
		return basicDataSource;
	}

	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {

		final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		final Properties properties = new Properties();
		properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		factoryBean.setHibernateProperties(properties);
		factoryBean.setAnnotatedPackages("co.in.springsecwithhib");
		factoryBean.setAnnotatedClasses(User.class, Authority.class, Role.class);
		// factoryBean.setPackagesToScan("co.in.springsecwithhib");
		// factoryBean.setAnnotatedClasses(User.class);

		return factoryBean;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager geTransactionManager() {

		final HibernateTransactionManager manager = new HibernateTransactionManager();
		manager.setSessionFactory(localSessionFactoryBean().getObject());
		return manager;
	}

}
