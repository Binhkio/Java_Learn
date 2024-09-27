package lvn.ecommerce.others.propertyResource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class DBChecking {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("lvn.ecommerce.otherAnnotations.propertyResource");
        context.refresh();
        DBConnection connection = context.getBean(DBConnection.class);
        System.out.println(connection.getAppName());
        Connection con = connection.getConnection();
        System.out.println(con.getMetaData().getDatabaseProductName());
        System.out.println(con.getMetaData().getDatabaseProductVersion());
    }
}
