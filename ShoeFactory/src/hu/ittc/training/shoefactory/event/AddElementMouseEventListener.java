package hu.ittc.training.shoefactory.event;

import hu.ittc.training.shoefactory.window.FormCreator;
import hu.ittc.training.shoefactory.window.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AddElementMouseEventListener implements MouseListener {

    private ArrayList objectList;
    private JTree source;
    private FormCreator formCreator;
    private MainFrame mainFrame;

    public AddElementMouseEventListener(ArrayList objectList, JTree source, FormCreator formCreator, MainFrame mainFrame) {
        this.objectList = objectList;
        this.formCreator = formCreator;
        this.source = source;
        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        formCreator.setVisible(true);
        Object newObject = formCreator.getCreatedObject();
        objectList.add(newObject);
        mainFrame.createAndReplaceJTree(objectList, formCreator, true);
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
