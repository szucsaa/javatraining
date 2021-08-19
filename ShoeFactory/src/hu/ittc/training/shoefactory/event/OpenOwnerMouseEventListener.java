package hu.ittc.training.shoefactory.event;

import hu.ittc.training.shoefactory.window.MainFrame;
import sun.applet.Main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OpenOwnerMouseEventListener implements MouseListener {

    MainFrame mainFrame;

    public OpenOwnerMouseEventListener(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        mainFrame.drawOwner();
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
