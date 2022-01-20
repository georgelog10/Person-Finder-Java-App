
package proiectbd;
import java.sql.*;

public class ProiectBD {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin1234";
    private static final String CONN_STRING = 
            "jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    public static void main(String[] args) {
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Conectat!");
        }catch(SQLException e){
            System.err.println(e);
        }
    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
