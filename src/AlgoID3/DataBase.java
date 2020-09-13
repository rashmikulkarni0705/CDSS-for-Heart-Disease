package AlgoID3;

import java.sql.Connection;

import java.sql.DriverManager;

public class DataBase {

    public static String username = "HEART";
    public static String password = "HEART";
    public static Connection con = null;
    public static boolean oracle = true;

    public static Connection getOracleConnection() {
        String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";

        if (!oracle) {
            driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            url="jdbc:sqlserver://localhost;database=LifeInsurance";
        }
        try {

            Class.forName(driver); // load Oracle driver

            con = DriverManager.getConnection(url, username, password);

            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        } // load Oracle driver
        return null;
    }
}
