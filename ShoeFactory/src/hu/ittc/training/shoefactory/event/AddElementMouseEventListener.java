package hu.ittc.training.shoefactory.event;

import hu.ittc.training.shoefactory.window.FormCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class AddElementMouseEventListener implements MouseListener {

    private ArrayList objectList;
    private JTree source;
    private FormCreator formCreator;

    public AddElementMouseEventListener(ArrayList objectList, JTree source, FormCreator formCreator) {
        this.objectList = objectList;
        this.formCreator = formCreator;
        this.source = source;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        formCreator.setVisible(true);
        Object newObject = formCreator.getCreatedObject();
        objectList.add(newObject);
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
