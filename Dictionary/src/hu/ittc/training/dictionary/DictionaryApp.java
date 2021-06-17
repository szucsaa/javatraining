package hu.ittc.training.dictionary;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;

import java.util.List;

public class DictionaryApp {

    public static void main(String[] args) {

        ModelReader fileReader = new ModelReader();

        Book book = new Book();
        fileReader.readBookContent(book, args[0]);

        Dictionary englishDictionary = new Dictionary();
        fileReader.readDictionaryFile(englishDictionary, args[1]);

    }
}
