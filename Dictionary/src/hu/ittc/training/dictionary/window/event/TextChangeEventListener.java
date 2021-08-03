package hu.ittc.training.dictionary.window.event;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TextChangeEventListener implements KeyListener {

    JButton jButton;

    public TextChangeEventListener(JButton jButton) {
        this.jButton = jButton;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        jButton.setEnabled(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
