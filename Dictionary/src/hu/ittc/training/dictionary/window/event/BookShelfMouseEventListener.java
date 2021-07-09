package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.window.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BookShelfMouseEventListener implements MouseListener {

    private MainFrame mainFrame;

    public BookShelfMouseEventListener(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        mainFrame.drawBookTree();
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
