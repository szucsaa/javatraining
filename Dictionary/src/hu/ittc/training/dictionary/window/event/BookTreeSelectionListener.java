package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class BookTreeSelectionListener implements TreeSelectionListener {

    private MainFrame mainFrame;
    private Shelf bookShelf;

    public BookTreeSelectionListener(MainFrame mainFrame, Shelf bookShelf) {
        this.mainFrame = mainFrame;
        this.bookShelf = bookShelf;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {

        Book chosenBook = (Book) bookShelf.getDocument(e.getPath().getLastPathComponent().toString());

        mainFrame.showContentArea(chosenBook.getName());

        for(String line: chosenBook.getBookContent())
            mainFrame.appendContentLine(line);

        mainFrame.drawPopup(e.getSource());
    }

}
