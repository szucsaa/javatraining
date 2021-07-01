package hu.ittc.training.dictionary.window;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.BookShelf;
import hu.ittc.training.dictionary.window.eventlistener.OpenBookMouseEventListener;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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


        ArrayList<Book> bookshelf = new ArrayList<>();
        Book book1 = new Book();
        book1.setName("The Great Gatsby");
        Book book2 = new Book();
        book2.setName("The Godfather");
        Book book3 = new Book();
        book3.setName("Crime and Punishment");
        Book book4 = new Book();
        book4.setName("Moby-Dick");
        bookshelf.add(book1);
        bookshelf.add(book2);
        bookshelf.add(book3);
        bookshelf.add(book4);

        bookshelf.forEach(bk -> translate.add(new JMenuItem(bk.getName())));


        jMenuBar.add(file);
        jMenuBar.add(translate);

        jFrame.setJMenuBar(jMenuBar);
        jFrame.setSize(1000, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
