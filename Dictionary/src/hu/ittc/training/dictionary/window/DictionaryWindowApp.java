package hu.ittc.training.dictionary.window;

import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.event.BookShelfMouseEventListener;
import hu.ittc.training.dictionary.window.event.OpenDocumentMouseEventListener;

import javax.swing.*;
import java.awt.*;

public class DictionaryWindowApp {

    public static Shelf bookShelf = new Shelf();
    public static Shelf dictionaryShelf = new Shelf();

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file =  new JMenu("File");
        JMenuItem openBook = new JMenuItem("Open Book");
        openBook.addMouseListener(new OpenDocumentMouseEventListener(bookShelf, OpenDocumentMouseEventListener.DocumentType.BOOK));
        JMenuItem openDictionary = new JMenuItem("Open Dictionary");
        openDictionary.addMouseListener(new OpenDocumentMouseEventListener(dictionaryShelf, OpenDocumentMouseEventListener.DocumentType.DICTIONARY));
        file.add(openBook);
        file.add(openDictionary);
        JMenu translate =  new JMenu("Translate");
        JMenuItem bookshelf = new JMenuItem("Bookshelf");
        translate.add(bookshelf);
        bookshelf.addMouseListener(new BookShelfMouseEventListener(jFrame));
        jMenuBar.add(file);
        jMenuBar.add(translate);
        jFrame.setJMenuBar(jMenuBar);

        jFrame.setSize(1000, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
