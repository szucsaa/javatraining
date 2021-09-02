package hu.ittc.training.shoefactory.persistence;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnector {

    private Connection conn;

    public DBConnector(Connection conn){
        this.conn = conn;
    }

    public ArrayList<Owner> readOwners(Integer querySize){
        ArrayList<Owner> owners = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("select * from owner "+(querySize==null?"":"where shoe is null and feetsize="+querySize)+";");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                int size = rs.getInt("feetsize");
                Owner o = new Owner(rs.getString("name"), size);
                String brand = rs.getString("shoe");
                if (brand != null){
                    Shoe s = new Shoe(size, brand,true);
                    o.setShoe(s);
                }
                owners.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return owners;
    }

    public ArrayList<Shoe> readShoes(Integer querySize) {
        ArrayList<Shoe> shoes = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement("select * from shoe "+(querySize==null?"":"where issold=0 and size="+querySize)+";");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()){
                String brand = rs.getString("brand");
                int size = rs.getInt("size");
                Integer isSold = rs.getInt("issold");

                Shoe s = new Shoe(size, brand, isSold==1?true:false);
                shoes.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return shoes;
    }

    public void saveOwner(Owner owner) {

        try (PreparedStatement ps = conn.prepareStatement("insert into owner values (?, ?, null);")) {

            ps.setString(1, owner.getName());
            ps.setInt(2, owner.getFeetSize());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void saveShoe(Shoe shoe) {

        try (PreparedStatement ps = conn.prepareStatement("insert into shoe values (?, ?, ?);")) {

            ps.setString(1, shoe.getBrand());
            ps.setInt(2, shoe.getSize());
            ps.setBoolean(3, false);

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateOwnersShoe(Owner owner, Shoe shoe) {
        try (PreparedStatement ps = conn.prepareStatement("update owner set shoe = ? where name=?;")) {
            ps.setString(1, shoe.getBrand());
            ps.setString(2, owner.getName());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (PreparedStatement ps = conn.prepareStatement("update shoe set issold = 1 where brand=? and size = ?;")) {
            ps.setString(1, shoe.getBrand());
            ps.setInt(2, shoe.getSize());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
