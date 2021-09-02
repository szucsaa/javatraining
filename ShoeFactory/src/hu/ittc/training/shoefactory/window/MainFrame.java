package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.event.*;
import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;
import hu.ittc.training.shoefactory.persistence.DBConnector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JDialog {

    private DBConnector dbConnector;

    private ArrayList<Owner> ownerList ;
    private ArrayList<Shoe> shoeList;

    private JLabel ownerLabel = new JLabel("Owner");
    private JTree ownerTree;

    private JLabel shoeLabel = new JLabel("Shoe");
    private JTree shoeTree;

    public MainFrame(DBConnector dbConnector) throws HeadlessException {

        this.dbConnector = dbConnector;

        createAndReplaceJTree(new OwnerFormCreator(dbConnector), false, false);
        createAndReplaceJTree(new ShoeFormCreator(dbConnector), false, false);

        drawFrame();
    }

    public void createAndReplaceJTree(FormCreator fc, boolean draw, boolean both){

        if (both || fc instanceof OwnerFormCreator) {
            JTree oldTree = ownerTree;
            ownerList = dbConnector.readOwners(null);
            ownerTree = new JTree(ownerList.toArray());
            ownerTree.addMouseListener(new DrawPopUpMouseListener(this, ownerList, ownerTree, new OwnerFormCreator(dbConnector)));
            if (draw) drawOwner(oldTree);
        }

        if (both || fc instanceof ShoeFormCreator) {
            JTree oldTree = shoeTree;
            shoeList = dbConnector.readShoes(null);
            shoeTree = new JTree(shoeList.toArray());
            shoeTree.addMouseListener(new DrawPopUpMouseListener(this, shoeList, shoeTree, new ShoeFormCreator(dbConnector)));
            if (draw) drawShoe(oldTree);
        }
    }

    private void drawFrame() {

        this.setTitle("Shoe Factory Application");

        JMenuBar jMenuBar = new JMenuBar();

        JMenu file =  new JMenu("File");
        jMenuBar.add(file);

        JMenuItem openOwner = new JMenuItem("Open Owner");
        openOwner.addMouseListener(new OpenOwnerMouseEventListener(this));
        file.add(openOwner);

        JMenuItem openShoe = new JMenuItem("Open Shoe");
        openShoe.addMouseListener(new OpenShoeMouseEventListener(this));
        file.add(openShoe);

        this.setJMenuBar(jMenuBar);
        this.setSize(1000, 500);
        this.setModal(true);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
    }

    public void drawOwner(JTree oldTree) {

        getContentPane().remove(ownerLabel);
        if (oldTree != null)
            getContentPane().remove(oldTree);

        getContentPane().add(ownerLabel);
        ownerLabel.setBounds(0,0,495,30);

        getContentPane().add(ownerTree);
        ownerTree.setBounds(0,30,495,470);

        repaint();
    }

    public void drawShoe(JTree oldTree) {

        getContentPane().remove(shoeLabel);
        if (oldTree != null)
            getContentPane().remove(oldTree);

        getContentPane().add(shoeLabel);
        shoeLabel.setBounds(500,0,495,30);

        getContentPane().add(shoeTree);
        shoeTree.setBounds(500,30,495,470);

        repaint();
    }

    public void drawPopup(JTree source, ArrayList objectList, FormCreator formCreator) {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem newJMenuItem = new JMenuItem("Add");
        popupMenu.add(newJMenuItem);
        newJMenuItem.addMouseListener(new AddElementMouseEventListener(objectList, source, formCreator, this));

        JMenu pairingMenu = new JMenu("Pairing");
        popupMenu.add(pairingMenu);
        pairingMenu.addMouseListener(new PairingMouseEventListener(objectList, source, formCreator, this, pairingMenu));


        popupMenu.show((JTree) source, 50, 0);
        popupMenu.setVisible(true);
    }

    public void drawListPopup(JMenu pairingMenu, Object source, FormCreator formCreator, int size, Object treeObject) {
        if (pairingMenu.getItemCount()>0) return;
        for (Object o : formCreator.getObjectList(size)){
            JMenuItem item = new JMenuItem(o.toString());
            item.addMouseListener(new PairingItemMouseEventListener(treeObject, o, this, formCreator, dbConnector));
            pairingMenu.add(item);
        }
        pairingMenu.getPopupMenu().pack();
    }
}
