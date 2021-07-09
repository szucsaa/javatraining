package hu.ittc.training.dictionary.window.event;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PopupMenuMouseEventListener implements MouseListener {

    public PopupMenuMouseEventListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

     }

    @Override
    public void mousePressed(MouseEvent e) {

        JOptionPane.showMessageDialog(null, "Hello!");
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
