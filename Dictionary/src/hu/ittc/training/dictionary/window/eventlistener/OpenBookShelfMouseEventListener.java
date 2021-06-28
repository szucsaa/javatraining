package hu.ittc.training.dictionary.window.eventlistener;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.window.DictionaryWindowApp;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OpenBookShelfMouseEventListener implements MouseListener {

    private final JFrame frame;

    public OpenBookShelfMouseEventListener() {
        this.frame = new JFrame();
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        String[] bookTitles = DictionaryWindowApp.bookShelf.getBooks().stream()
                .map(Book::getName)
                .toArray(String[]::new);
        JList<String> jList = new JList<>(bookTitles);
        JScrollPane scrollPane = new JScrollPane(jList);
        frame.getContentPane().add(scrollPane);
        frame.pack();
        frame.setVisible(true);
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
