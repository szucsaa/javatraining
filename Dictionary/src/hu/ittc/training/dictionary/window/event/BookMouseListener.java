package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.window.MainFrame;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BookMouseListener implements MouseListener {

    private JTree tree;
    private MainFrame mainFrame;

    public BookMouseListener(JTree tree, MainFrame mainFrame) {
        this.tree = tree;
        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        TreePath selectedPath = tree.getPathForLocation(e.getX(), e.getY());
        if (selectedPath==null)
            return;
        Book book = mainFrame.searchBook(selectedPath.getLastPathComponent().toString());

        if(SwingUtilities.isRightMouseButton(e))
            mainFrame.drawPopup(e.getSource(), book);
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
