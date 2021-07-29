package hu.ittc.training.dictionary.io;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModelIOHandler {

    public void readDictionaryFile(Dictionary dictionary, String filePath) {
        File dictFile = new File(filePath);
        readDictionaryFile(dictionary, dictFile);
    }

    public void readDictionaryFile(Dictionary dictionary, File dictFile) {
        String line;
        try {
            dictionary.setName(dictFile.getName());
            dictionary.setPath(dictFile.getPath());
            FileReader file = new FileReader(dictFile);
            BufferedReader br = new BufferedReader(file);

            while ((line = br.readLine()) != null) {
                String[] dictionaryLine = line.split(":");
                dictionary.addWordPair(dictionaryLine[0], dictionaryLine[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readBookContent(Book book, String path) {
        File bookFile = new File(path);
        readBookContent(book, bookFile);
    }

    public void readBookContent(Book book, File bookFile) {
        List<String> bookContentByLines = new ArrayList<>();
        String line;
        try {
            book.setName(bookFile.getName());
            book.setPath(bookFile.getPath());
            FileReader file = new FileReader(bookFile);
            BufferedReader br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                bookContentByLines.add(line);
            }
            book.setBookContent(bookContentByLines);
            br.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void writeBookContent(Book book, String path){
        List<String> bookContentByLines = book.getBookContent();
        try{
            PrintWriter pw = new PrintWriter(new FileWriter(path));
            for(String line : bookContentByLines)
                pw.println(line);
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeDictionary(Dictionary dictionary) {
        File file=new File(dictionary.getPath());
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
            for (String key:dictionary.getWordPairs().keySet()) {
                bw.write(key+":"+dictionary.getWordPairs().get(key)+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
