package hu.ittc.training.shoefactory.persistence;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {

    public static ArrayList<Owner> readOwners(Connection conn){
        ArrayList<Owner> owners = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from owner;");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int size = rs.getInt(2);
                Owner o = new Owner(rs.getString(1), size);
                String brand = rs.getString(3);
                if (brand != null){
                    Shoe s = new Shoe(size, brand,true);
                    o.setShoe(s);
                }
                owners.add(o);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owners;
    }
}
