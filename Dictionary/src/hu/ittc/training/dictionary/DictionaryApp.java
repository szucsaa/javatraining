package hu.ittc.training.dictionary;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Translator;

public class DictionaryApp {

    public static void main(String[] args) {

        ModelIOHandler fileHandler = new ModelIOHandler();

        Book book = new Book();
        fileHandler.readBookContent(book, args[0]);

        Dictionary englishDictionary = new Dictionary();
        fileHandler.readDictionaryFile(englishDictionary, args[1]);

        Book translated = new Book();
        Translator translator = new Translator(englishDictionary);
        translator.translate(book, translated);

        fileHandler.writeBookContent(translated, args[0]+"_trans");



    }
}
