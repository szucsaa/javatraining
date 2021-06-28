package hu.ittc.training.dictionary.window.eventlistener;

import hu.ittc.training.dictionary.DictionaryApp;
import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.window.DictionaryWindowApp;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListBooksMouseEventListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        JFrame listOfBooksjFrame = new JFrame("List of books");
        JTextArea listOfBooksTextArea = new JTextArea();
        listOfBooksTextArea.setBounds(10, 10, 200, 50);
        listOfBooksTextArea.setText("book1 book2");
        StringBuffer sb = new StringBuffer();
        for (Book book : DictionaryWindowApp.bookShelf.getBooks()) {
            sb.append(book.getName());
            sb.append(System.lineSeparator());
        }
        listOfBooksTextArea.setText(sb.toString());
        listOfBooksTextArea.setVisible(true);
        listOfBooksjFrame.add(listOfBooksTextArea);
        listOfBooksjFrame.setSize(500, 400);
        listOfBooksjFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        listOfBooksjFrame.setVisible(true);
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
