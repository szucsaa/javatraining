package hu.ittc.training.dictionary.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> wordpairs = new HashMap<>();

    public Map<String, String> getDictionary(String dictionaryFilePath) {
        return wordpairs;
    }

    public void addWordPairs(String key, String value){
        wordpairs.put(key, value);
    }

}
