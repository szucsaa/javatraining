package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Translator;
import hu.ittc.training.dictionary.window.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopupMenuMouseEventListener implements MouseListener {

    private Translator translator;
    private Book book;
    private MainFrame mainFrame;
    private Dictionary dictionary;

    public PopupMenuMouseEventListener(Dictionary dictionary, Book book, MainFrame mainFrame) {
        this.dictionary = dictionary;
        this.translator = new Translator(dictionary);
        this.book = book;
        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

     }

    @Override
    public void mousePressed(MouseEvent e) {
        Book translatedBook = new Book();
        String newName = book.getName() + " translated by " + dictionary.getName();
        translatedBook.setName(newName);
        String newPath = book.getPath().replace(book.getName(), newName);
        translatedBook.setPath(newPath);
        translator.translate(book, translatedBook);
        mainFrame.showContentArea(translatedBook);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

     }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

     }
}
