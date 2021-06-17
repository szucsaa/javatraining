package hu.ittc.training.dictionary;

import java.io.*;

public class FileReader {

    public void readDictionaryFile(Dictionary dictionary, String filePath) {
        String line;
        try {
            FileInputStream ownerFile = new FileInputStream(filePath);
            InputStreamReader ir = new InputStreamReader(ownerFile);
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
}
