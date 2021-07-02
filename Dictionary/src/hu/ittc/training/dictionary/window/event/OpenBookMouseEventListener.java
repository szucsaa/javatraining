package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.io.ModelIOHandler;
import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.window.DictionaryWindowApp;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class OpenBookMouseEventListener implements MouseListener {

    private JFileChooser jFileChooser = new JFileChooser();
    private ModelIOHandler modelIOHandler = new ModelIOHandler();

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        jFileChooser.showOpenDialog(e.getComponent());
        File selectedFile = jFileChooser.getSelectedFile();
        Book book = new Book();
        modelIOHandler.readBookContent(book, selectedFile);
        DictionaryWindowApp.bookShelf.addBook(book);
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
