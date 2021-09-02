package hu.ittc.training.shoefactory.event;

import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.persistence.DBConnector;
import hu.ittc.training.shoefactory.window.MainFrame;

import hu.ittc.training.shoefactory.window.FormCreator;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PairingItemMouseEventListener implements MouseListener {

    private Object treeObject;
    private Object listObject;
    private MainFrame mainFrame;
    private FormCreator formCreator;
    private DBConnector dbConnector;

    public PairingItemMouseEventListener(Object treeObject, Object listObject, MainFrame mainFrame, FormCreator formCreator, DBConnector dbConnector) {
        this.treeObject = treeObject;
        this.listObject = listObject;
        this.mainFrame = mainFrame;
        this.formCreator = formCreator;
        this.dbConnector = dbConnector;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Owner owner = (Owner) (treeObject instanceof Owner ? treeObject : listObject);
        Shoe shoe = (Shoe) (treeObject instanceof Shoe ? treeObject : listObject);
        owner.setShoe(shoe);
        shoe.setSold(true);
        dbConnector.updateOwnersShoe(owner, shoe);
        mainFrame.createAndReplaceJTree(formCreator, true, true);
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
