package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.window.MainFrame;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DocMouseListener implements MouseListener {

    private JTree tree;
    private MainFrame mainFrame;
    private Document.DocumentType docType;

    public DocMouseListener(JTree tree, MainFrame mainFrame, Document.DocumentType docType) {
        this.tree = tree;
        this.mainFrame = mainFrame;
        this.docType = docType;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        TreePath selectedPath = tree.getPathForLocation(e.getX(), e.getY());
        if (selectedPath==null)
            return;
        Document doc = mainFrame.pickDoc(selectedPath.getLastPathComponent().toString(), docType);

        if(SwingUtilities.isRightMouseButton(e) && doc instanceof Book)
            mainFrame.drawPopup(e.getSource(), (Book) doc);
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
