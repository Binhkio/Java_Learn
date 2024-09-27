package lvn.ecommerce.others.propertyResource;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    @Getter
    @Value("${APP_NAME}")
    private String appName;
    @Value("${DB_DRIVER_CLASS}")
    private String driverClass;
    @Value("${DB_URL}")
    private String dbURL;
    @Value("${DB_USERNAME}")
    private String userName;
    @Value("${DB_PASSWORD}")
    private char[] password;
    private Connection con;
    public DBConnection() {}
    public Connection getConnection() {
        if (this.con != null) return con;
        Connection con = null;
        try {
            Class.forName(driverClass);
            con = DriverManager.getConnection(dbURL, userName, String.valueOf(password));
            System.out.println("Successfully Created DB Connection");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        this.con = con;
        return con;
    }
    public DBConnection(String driverClass, String dbURL, String userName, char[] password) {
        this.driverClass = driverClass;
        this.dbURL = dbURL;
        this.userName = userName;
        this.password = password;
    }
    public void close() {
        System.out.println("DBConnection close called");
        if (this.con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
