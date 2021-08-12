package hu.ittc.training.shoefactory;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.persistence.DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShoeDatabaseApp {

    public static void main(String[] args) {
        try {
            Class.forName(args[0]).newInstance();
            Connection conn = DriverManager.getConnection(args[1], args[2], args[3]);
            for (Owner o: DBConnector.readOwners(conn)){
                System.out.println(o.toString());
            }
            for (Shoe s : DBConnector.readShoes(conn)) {
                System.out.println(s.toString());
            }
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
