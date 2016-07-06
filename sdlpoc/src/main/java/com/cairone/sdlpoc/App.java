package com.cairone.sdlpoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.cairone.sdlpoc.datasources.InMemoryDataSourceConfiguration;
import com.sdl.odata.service.ODataServiceConfiguration;

@Configuration
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class })
@Import({
        InMemoryDataSourceConfiguration.class,
        ODataServiceConfiguration.class
})
@ComponentScan
public class App 
{
	@Bean
	public Logger logger() {
		return LoggerFactory.getLogger(App.class);
	}
	
    public static void main( String[] args ) {
    	SpringApplication.run(App.class, args);
    }
}
