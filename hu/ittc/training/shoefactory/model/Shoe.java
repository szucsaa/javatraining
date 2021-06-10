package hu.ittc.training.shoefactory.model;

public class Shoe {

    private int size;
    private String brand;
    private boolean isSold;

    public Shoe (int size, String brand, boolean isSold){

        this.brand = brand;
        this.size = size;
        this.isSold = isSold;
    }

    public int getSize(){
        return size;
    }

    public String getBrand(){
        return brand;
    }

    public String toString(){
        return (isSold?"SOLD:":"")+this.brand+";"+this.size;
    }

    public void setSold(boolean b) {
        this.isSold = b;
    }

    public boolean isSold() {
        return this.isSold;
    }
}
