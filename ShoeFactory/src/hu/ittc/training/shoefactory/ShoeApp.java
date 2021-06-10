package hu.ittc.training.shoefactory;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.model.ShoeStore;
import hu.ittc.training.shoefactory.persistence.FileProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class ShoeApp {


    private static ArrayList<Owner> owners;
    private static ShoeStore store;
    private static HashMap<String, ShoeStore> shoeStoreMap = new HashMap<>();

    public static void main(String[] args) {

        owners = FileProcessor.readOwners(args[0]);

        for (int i = 1; i < args.length; i++) {
           store =  FileProcessor.readStore(args[i]);
           System.out.println("Bolt megnyitva:\t"+store.getName());
           shoeStoreMap.put(store.getName(), store);
        }


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String storeName = readStoreName(br);
            do {
                if (shoeStoreMap.containsKey(storeName)) {
                    store = shoeStoreMap.get(storeName);
                    coupling(owners, store);
                    FileProcessor.saveList(owners, args[0]);
                    FileProcessor.saveList(store.getList(), store.getFileName());
                    System.out.println("A " + storeName + " boltból a bevásárlás megtörtént!");
                } else {
                    System.out.println("A bolt nem található");
                }
            } while (!(storeName = readStoreName(br)).equals("stop"));
            br.close();
        }
        catch (IOException iox){}
    }

    private static void coupling(ArrayList<Owner> owners, ShoeStore store) {

        for(Owner o: owners){
            if (o.getShoe() == null){
                Shoe s = store.buyShoe(o.getFeetSize());
                o.setShoe(s);
            }
        }
    }

    private static String readStoreName(BufferedReader br) throws IOException {
        System.out.println("Kérem adja meg a bolt nevét:");
        String line = null;
        line = br.readLine();
        return line;
    }



}
