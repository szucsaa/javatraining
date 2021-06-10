package hu.ittc.training.shoefactory;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.model.ShoeStore;
import hu.ittc.training.shoefactory.persistence.FileProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ShoeClient {

    private static ArrayList<Owner> owners;
    private static Socket storeSocket;

    public static void main(String[] args) {

        owners = FileProcessor.readOwners(args[0]);

        try {
            storeSocket = new Socket(args[1], Integer.valueOf(args[2]));
            PrintWriter outstream = new PrintWriter(storeSocket.getOutputStream());
            BufferedReader instream = new BufferedReader(new InputStreamReader(storeSocket.getInputStream()));

            coupling(outstream, instream);

            storeSocket.close();

            FileProcessor.saveList(owners, args[0]);
            System.out.println("A bevásárlás elévegezve!");
        } catch(UnknownHostException u){
            System.out.println("Ismeretlen cím!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void coupling(PrintWriter outstream, BufferedReader instream) throws IOException {
        for(Owner o : owners){
            outstream.println(o.getFeetSize());
            outstream.flush();
            String brand = instream.readLine();
            System.out.println(o.getName()+" igényére válasz érkezett:\t"+brand);
            if (!ShoeStore.NOT_AVAILABLE.equals(brand)){
                Shoe s = new Shoe(o.getFeetSize(), brand, true);
                o.setShoe(s);
            }
        }
    }
}
