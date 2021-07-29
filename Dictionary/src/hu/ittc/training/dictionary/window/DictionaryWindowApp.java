package hu.ittc.training.dictionary.window;

import hu.ittc.training.dictionary.model.Shelf;

public class DictionaryWindowApp {

    public static Shelf bookShelf = new Shelf();
    public static Shelf dictionaryShelf = new Shelf();

    public static void main(String[] args) {
        new MainFrame(bookShelf, dictionaryShelf);
    }
}
