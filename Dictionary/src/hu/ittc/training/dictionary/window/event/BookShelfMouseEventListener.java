package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.window.DictionaryWindowApp;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BookShelfMouseEventListener implements MouseListener {

    private JFrame mainFrame;

    public BookShelfMouseEventListener(JFrame jFrame) {
        this.mainFrame = jFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mainFrame.getContentPane().removeAll();
        JLabel label = new JLabel("Bookshelf");
        label.setBounds(0,0,100,20);
        mainFrame.getContentPane().add(label);
        JTree booktree = new JTree(DictionaryWindowApp.bookShelf.getDocuments().toArray());
        booktree.setBounds(0,20,500,500);
        booktree.addTreeSelectionListener(new BookTreeSelectionListener(mainFrame));
        mainFrame.getContentPane().add(booktree);
        mainFrame.repaint();
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
