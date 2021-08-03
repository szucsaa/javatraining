package hu.ittc.training.dictionary.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public String toString(){
        return name;
    }

    @Override
    public List<String> getContentAsList() {
        return wordpairs.keySet().stream().sorted().map(s -> s+":"+wordpairs.get(s)).collect(Collectors.toList());
    }

    @Override
    public void setContentAsList(List<String> content) {
        wordpairs = new HashMap<>();
        for (String pair : content) {
            String[] p = pair.split(":");
            addWordPair(p[0], p[1]);
        }
    }
}
