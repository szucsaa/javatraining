package hu.ittc.training.dictionary;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ModelReader {

    public void readDictionaryFile(Dictionary dictionary, String filePath) {
        String line;
        try {
            FileInputStream File = new FileInputStream(filePath);
            InputStreamReader ir = new InputStreamReader(File);
            BufferedReader br = new BufferedReader(ir);

            while ((line = br.readLine()) != null) {
                String[] dictionaryLine = line.split(":");
                dictionary.addWordPairs(dictionaryLine[0], dictionaryLine[1]);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readBookContent(Book book, String path) {
        List<String> bookContentByLines = new ArrayList<>();
        String line;
        try {
            FileReader file = new FileReader(path);
            BufferedReader br = new BufferedReader(file);
            while ((line = br.readLine()) != null) {
                bookContentByLines.add(line);
            }
            book.setBookContent(bookContentByLines);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return bookContentByLines;
    }
}
