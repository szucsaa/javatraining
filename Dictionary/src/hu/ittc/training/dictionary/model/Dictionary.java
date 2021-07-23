package hu.ittc.training.dictionary.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dictionary extends Document {

    private Map<String, String> wordpairs = new HashMap<>();

    public Map<String, String> getWordPairs() {
        return wordpairs;
    }

    public void addWordPair(String key, String value){
        wordpairs.put(key, value);
    }

    public String getTranslation(String word){
        return wordpairs.get(word);
    }

    public void saveDictionary() {
        File file=new File(this.path);
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
            for (String key:wordpairs.keySet()) {
                bw.write(key+":"+wordpairs.get(key)+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
