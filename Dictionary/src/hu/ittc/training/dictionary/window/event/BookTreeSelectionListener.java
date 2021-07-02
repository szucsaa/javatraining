package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.DictionaryWindowApp;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

public class BookTreeSelectionListener implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {

        Book chosenBook = (Book) DictionaryWindowApp.bookShelf.getDocument(e.getPath().getLastPathComponent().toString());
        JPopupMenu popupMenu = new JPopupMenu();
        for (Document dictionary : DictionaryWindowApp.dictionaryShelf.getDocuments()) {
            JMenuItem newJMenuItem = new JMenuItem(dictionary.getName());
            popupMenu.add(newJMenuItem);
        }
        popupMenu.show((JTree) e.getSource(), 50, 0);
        popupMenu.setVisible(true);
    }

}
