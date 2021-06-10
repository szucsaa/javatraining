package hu.ittc.training.shoefactory;

import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.model.ShoeStore;
import hu.ittc.training.shoefactory.persistence.FileProcessor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class ShoeServer {

    public static final String START_SUCKING = "Start sucking!";
    public static final String END_SUCKING = "End sucking!";
    private static ShoeStore store;
    private static ServerSocket server;

    public static void main(String[] args) {
        
        if(args.length >= 4) {
            ArrayList<Shoe> demandList = new ArrayList<>();
            if (args.length == 5){
                demandList = FileProcessor.readShoes(args[4]);
            }
            suckStock(args[2], Integer.valueOf(args[3]), args[0], demandList);
        }

        store =  FileProcessor.readStore(args[0]);
        System.out.println("Bolt megnyitva:\t"+store.getName());

        try {
            server = new ServerSocket(Integer.valueOf(args[1]));
            while (store.isShoeAvailable()==true) {
                Socket client = server.accept();
                System.out.println("Kliens csatlakozva:\t" + client.getInetAddress().toString());
                PrintWriter outstream = new PrintWriter(client.getOutputStream());
                BufferedReader instream = new BufferedReader(new InputStreamReader(client.getInputStream()));

                String line = instream.readLine();
                if (START_SUCKING.equals(line)) {
                    pushStock(outstream, instream);
                }
                else
                    serveClient(outstream, instream, line);

                FileProcessor.saveList(store.getList(), store.getFileName());
                instream.close();
                outstream.close();
            }
            server.close();
            System.out.println("Bolt bezár!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void pushStock(PrintWriter outstream, BufferedReader instream) throws IOException {
        ArrayList<String> demandList = new ArrayList<>();
        String line = instream.readLine();
        while (!END_SUCKING.equals(line)){
            demandList.add(line);
            line = instream.readLine();
        }

        System.out.println("Készletküldés folyamatban!");
        for(Shoe s: store.getList()){
            if (demandList.isEmpty() || demandList.contains(s.toString())) {
                outstream.println(s.toString());
                store.remove(s);
            }
        }
        System.out.println("Készletküldés elvégezve!");
        outstream.flush();
    }

    private static void serveClient(PrintWriter outstream, BufferedReader instream, String line) throws IOException {
        while (line != null) {
            Integer size = Integer.valueOf(line);
            Shoe s = store.buyShoe(size);
            if (s != null) {
                outstream.println(s.getBrand());
                System.out.println("Igény kiszolgálva:\t" + size);
            } else {
                outstream.println(ShoeStore.NOT_AVAILABLE);
                System.out.println("Igény nem teljesíthető:\t" + size);

            }
            outstream.flush();
            line = instream.readLine();
        }
    }


    private static void suckStock(String hostName, int port, String fileName, ArrayList<Shoe> demandList){
        Socket storeSocket;
        try {
            storeSocket = new Socket(hostName, port);
            PrintWriter outstream = new PrintWriter(storeSocket.getOutputStream());
            BufferedReader instream = new BufferedReader(new InputStreamReader(storeSocket.getInputStream()));

            PrintWriter stockFile = FileProcessor.openFileToWrite(fileName, true);
            sucking(outstream, instream, stockFile, demandList);
            stockFile.close();

            outstream.close();
            instream.close();
            storeSocket.close();

            System.out.println("Szipkázás elévegezve!");
        } catch(UnknownHostException u){
            System.out.println("Ismeretlen cím!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sucking(PrintWriter outstream, BufferedReader instream, PrintWriter stockFile, ArrayList<Shoe> demandList) throws IOException {
        outstream.println(START_SUCKING);
        for(Shoe shoe: demandList){
            outstream.println(shoe.toString());
        }
        outstream.println(END_SUCKING);
        outstream.flush();
        String line = instream.readLine();
        while(line != null){
            System.out.println("Készlet átvéve:\t"+line);
            stockFile.append("\n"+line);
            line = instream.readLine();
        }
    }
}
