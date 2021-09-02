package hu.ittc.training.shoefactory.event;

import hu.ittc.training.shoefactory.window.MainFrame;

import hu.ittc.training.shoefactory.window.FormCreator;
import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class PairingMouseEventListener implements MouseListener {
    private ArrayList objectList;
    private JTree source;
    private FormCreator formCreator;
    private MainFrame mainFrame;
    private JMenu pairingMenu;

    public PairingMouseEventListener(ArrayList objectList, JTree source, FormCreator formCreator, MainFrame mainFrame, JMenu pairingMenu) {
        this.objectList = objectList;
        this.formCreator = formCreator;
        this.source = source;
        this.mainFrame = mainFrame;
        this.pairingMenu = pairingMenu;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        TreePath tp = source.getSelectionPath();
        if (tp == null) return;

        String str = tp.toString();
        int size = Integer.parseInt(str.substring(str.indexOf(';')+1,str.length()-1).replace(";",""));

        JTree.DynamicUtilTreeNode treeO = (JTree.DynamicUtilTreeNode) tp.getLastPathComponent();
        Object treeObject = treeO.getUserObject();
        mainFrame.drawListPopup(pairingMenu, e.getSource(), formCreator, size, treeObject);
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
