package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.window.MainFrame;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class BookTreeSelectionListener implements TreeSelectionListener {

    private MainFrame mainFrame;

    public BookTreeSelectionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Book book = mainFrame.searchBook(e.getPath().getLastPathComponent().toString());
        mainFrame.drawPopup(e.getSource(), book);
    }

}
