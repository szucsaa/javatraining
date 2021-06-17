package hu.ittc.training.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    private Map<String, String> dictionary = new HashMap<>();

    public Map<String, String> getDictionary(String dictionaryFilePath) {
        return dictionary;
    }

}
