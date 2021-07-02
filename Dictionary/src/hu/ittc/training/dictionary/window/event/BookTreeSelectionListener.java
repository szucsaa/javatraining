package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.DictionaryWindowApp;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;

public class BookTreeSelectionListener implements TreeSelectionListener {
    private JFrame mainFrame;

    public BookTreeSelectionListener(JFrame jFrame) {
        this.mainFrame = jFrame;
    }
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

        JPanel jp=new JPanel(new FlowLayout(FlowLayout.RIGHT));    //Create a JPanel object
        JTextArea jta=new JTextArea(10,20);

        chosenBook.getBookContent().forEach(jta::append);

        JScrollPane jsp=new JScrollPane(jta);    //Put the text field into the rolling window
        //Dimension size=jta.getPreferredSize();    //Get the preferred size of the text field
        //jsp.setBounds(200,90,size.width,size.height);
        jp.add(jsp);    //Add JScrollPane to JPanel container
        mainFrame.add(jp);    //Add the JPanel container to the JFrame container
    }

}
