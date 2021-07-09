package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Translator;
import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.window.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopupMenuMouseEventListener implements MouseListener {

    private Book book;
    private Dictionary dictionary;
    private MainFrame mainFrame;

    public PopupMenuMouseEventListener(Book book, Dictionary dictionary, MainFrame mainFrame) {

        this.book = book;
        this.dictionary = dictionary;
        this.mainFrame = mainFrame;
    }


    public void mouseClicked(MouseEvent e) {

     }

    @Override
    public void mousePressed(MouseEvent e) {

        Translator translator = new Translator(dictionary);
        Book translatedBook = new Book();
        translator.translate(book, translatedBook);

        mainFrame.appendContentLine("");
        for(String line: translatedBook.getBookContent())
            mainFrame.appendContentLine(line);
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
