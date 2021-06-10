package hu.ittc.training.shoefactory.persistence;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.model.ShoeStore;

import java.io.*;
import java.util.ArrayList;

public class FileProcessor {

    public static ArrayList<Owner> readOwners(String fileName) {
        String line;
        ArrayList<Owner> owners = new ArrayList<>();
        try {
            FileInputStream ownerFile = new FileInputStream(fileName);
            InputStreamReader ir = new InputStreamReader(ownerFile);
            BufferedReader br = new BufferedReader(ir);
            do {
                line = br.readLine();
                if (line != null) {
                    String[] ownerLine = line.split(";");
                    int size = Integer.parseInt(ownerLine[1]);
                    Owner owner = new Owner(ownerLine[0], size);
                    if (ownerLine.length>2) {
                        Shoe shoe = new Shoe(size, ownerLine[2], true);
                        owner.setShoe(shoe);
                    }
                    owners.add(owner);
                }
            } while (line != null);

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return owners;
    }

    public static ArrayList<Shoe> readShoes(String fileName) {
        String line;
        ArrayList<Shoe> shoes = new ArrayList<>();
        try {
            FileInputStream ownerFile = new FileInputStream(fileName);
            InputStreamReader ir = new InputStreamReader(ownerFile);
            BufferedReader br = new BufferedReader(ir);
            do {
                line = br.readLine();
                if (line != null) {
                    String[] shoesLine = line.split(";");
                    int size = Integer.parseInt(shoesLine[1]);
                    String brand = null;
                    boolean isSold = false;
                    if (shoesLine[0].startsWith("SOLD:")) {
                        isSold = true;
                        brand = shoesLine[0].replace("SOLD:", "");
                    } else
                        brand = shoesLine[0];
                    Shoe shoe = new Shoe(size, brand, isSold);
                    shoes.add(shoe);
                }
            } while (line != null);

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return shoes;
    }

    public static ShoeStore readStore(String fileName){
        ArrayList<Shoe> shoes = readShoes(fileName);
        int pos = fileName.indexOf('.');
        int lastpos = fileName.lastIndexOf('\\');
        String storeName = fileName.substring(lastpos+1,pos);
        return new ShoeStore(storeName ,shoes, fileName);
    }

    public static void saveList(ArrayList list, String fileName) {
        try {
            PrintWriter pw = openFileToWrite(fileName, false);
            for(Object o : list){
                pw.println(o.toString());
            }
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static PrintWriter openFileToWrite(String fileName, boolean append) throws FileNotFoundException {
        FileOutputStream ownerFile = new FileOutputStream(fileName, append);
        PrintWriter pw = new PrintWriter(ownerFile);
        return pw;
    }
}
