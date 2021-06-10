package hu.ittc.training.shoefactory.model;

import java.util.ArrayList;

public class ShoeStore {

    public static String NOT_AVAILABLE = "notInStock";

    private String name;
    private ArrayList<Shoe> stock = new ArrayList<>();
    private String fileName;

    public ShoeStore (String name, ArrayList<Shoe> stock, String fileName){
        this.fileName = fileName;
        this.name = name;
        this.stock = stock;
    }

    public Shoe buyShoe(int size){
        for(Shoe s: stock){
            if (!s.isSold() && size == s.getSize()){
                s.setSold(true);
                return s;
            }
        }
        return null;
    }

    public ArrayList<Shoe> getList() {
        ArrayList<Shoe> newList = new ArrayList<>();
        newList.addAll(stock);
        return newList;
    }

    public String getName(){
        return this.name;
    }

    public String getFileName(){
        return this.fileName;
    }

    public boolean isShoeAvailable() {
        for(Shoe s: stock){
            if (!s.isSold())
                return true;
        }
        return false;
    }

    public void remove(Shoe s) {
        this.stock.remove(s);
    }
}
