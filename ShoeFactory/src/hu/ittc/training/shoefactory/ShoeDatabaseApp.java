package hu.ittc.training.shoefactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShoeDatabaseApp {

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.OracleDriver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "system", "admin");
            conn.close();

            Class.forName("org.firebirdsql.jdbc.FBDriver").newInstance();
            conn = DriverManager.getConnection("jdbc:firebirdsql://localhost:3050/c:/data/test.fdb", "sysdba", "sysdba");
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
