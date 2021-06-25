package hu.ittc.training.dictionary.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private String name;

    private Map<String, String> wordpairs = new HashMap<>();

    public Map<String, String> getWordPairs() {
        return wordpairs;
    }

    public void addWordPair(String key, String value){
        wordpairs.put(key, value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranslation(String word){
        return wordpairs.get(word);
    }
}
