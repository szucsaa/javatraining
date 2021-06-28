package hu.ittc.training.dictionary.window;

import hu.ittc.training.dictionary.model.BookShelf;
import hu.ittc.training.dictionary.window.eventlistener.OpenBookMouseEventListener;
import hu.ittc.training.dictionary.window.eventlistener.OpenBookShelfMouseEventListener;

import javax.swing.*;

public class DictionaryWindowApp {

    public static BookShelf bookShelf = new BookShelf();

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file =  new JMenu("File");
        JMenuItem openBook = new JMenuItem("Open Book");
        openBook.addMouseListener(new OpenBookMouseEventListener());
        JMenuItem openDictionary = new JMenuItem("Open Dictionary");
        file.add(openBook);
        file.add(openDictionary);

        JMenu translate =  new JMenu("Translate");
        JMenuItem openBookShelf = new JMenuItem("Open Bookshelf");
        translate.add(openBookShelf);
        openBookShelf.addMouseListener(new OpenBookShelfMouseEventListener());

        jMenuBar.add(file);
        jMenuBar.add(translate);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.setSize(1000, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
