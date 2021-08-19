package hu.ittc.training.shoefactory.event;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.window.FormCreator;
import hu.ittc.training.shoefactory.window.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DrawPopUpMouseListener implements MouseListener {

    MainFrame mainFrame;
    ArrayList objectList;
    JTree objectTree;
    FormCreator formCreator;

    public DrawPopUpMouseListener(MainFrame mainFrame, ArrayList objectList, JTree objectTree, FormCreator formCreator) {
        this.objectList = objectList;
        this.mainFrame = mainFrame;
        this.objectTree = objectTree;
        this.formCreator = formCreator;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        if(SwingUtilities.isRightMouseButton(e))
            mainFrame.drawPopup(objectTree, objectList, formCreator);
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
