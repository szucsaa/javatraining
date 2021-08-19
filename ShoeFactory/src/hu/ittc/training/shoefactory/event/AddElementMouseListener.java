package hu.ittc.training.shoefactory.event;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.window.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AddElementMouseListener implements MouseListener {

    MainFrame mainFrame;

    public AddElementMouseListener(MainFrame mainFrame, ArrayList objectList, JTree objectTree) {

        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(SwingUtilities.isRightMouseButton(e))
            mainFrame.drawPopup(e.getSource());
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
