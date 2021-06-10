package hu.ittc.training.shoefactory.model;

public class Owner {

    private String name;
    private int feetSize;
    private Shoe shoe = null;

    public Owner (String ownerName, int feetSize){
        this.name = ownerName;
        this.feetSize = feetSize;
    }

    public String toString(){
        return this.name+";"+this.feetSize+";"+(this.shoe!=null?this.shoe.getBrand():"");
    }

    public Shoe getShoe() {
        return shoe;
    }

    public void setShoe(Shoe shoe){
        this.shoe=shoe;
    }

    public String getName(){
        return this.name;
    }

    public int getFeetSize(){
        return feetSize;
    }
}
