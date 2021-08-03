package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.window.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShelfMouseEventListener implements MouseListener {

    private MainFrame mainFrame;
    private Document.DocumentType doctype;

    public ShelfMouseEventListener(MainFrame mainFrame, Document.DocumentType doctype) {
        this.mainFrame = mainFrame;
        this.doctype = doctype;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mainFrame.drawBookTree(doctype,false);
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
