import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/iiits","root","Sadhu2002@");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}