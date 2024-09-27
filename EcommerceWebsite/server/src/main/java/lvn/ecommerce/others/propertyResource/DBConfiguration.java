package lvn.ecommerce.others.propertyResource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "classpath:database.properties", ignoreResourceNotFound = true)
public class DBConfiguration {
    @Autowired
    Environment env;

    @Bean
    public DBConnection getDBConnection() {
        System.out.println("Getting DBConnection Bean for App: " + env.getProperty("APP_NAME"));
        DBConnection dbConnection = new DBConnection();
        return dbConnection;
    }
}
