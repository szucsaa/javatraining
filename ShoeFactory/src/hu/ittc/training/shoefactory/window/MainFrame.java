package hu.ittc.training.shoefactory.window;

import hu.ittc.training.shoefactory.event.AddElementMouseListener;
import hu.ittc.training.shoefactory.event.OpenOwnerMouseEventListener;
import hu.ittc.training.shoefactory.event.OpenShoeMouseEventListener;
import hu.ittc.training.shoefactory.model.Owner;
import hu.ittc.training.shoefactory.model.Shoe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private ArrayList<Owner> ownerList ;
    private ArrayList<Shoe> shoeList;

    private JLabel ownerLabel = new JLabel("Owner");
    private JTree ownerTree;

    private JLabel shoeLabel = new JLabel("Shoe");
    private JTree shoeTree;

    public MainFrame(ArrayList<Owner> ownerList, ArrayList<Shoe> shoeList) throws HeadlessException {

        this.ownerList = ownerList;
        this.shoeList = shoeList;

        ownerTree = new JTree(ownerList.toArray());
        ownerTree.addMouseListener(new AddElementMouseListener(this, ownerList, ownerTree));

        shoeTree = new JTree(shoeList.toArray());
        shoeTree.addMouseListener(new AddElementMouseListener(this, shoeList, shoeTree));

        drawFrame();
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setLayout(null);

        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);
    }

    public void drawOwner() {

        getContentPane().remove(ownerLabel);
        getContentPane().remove(ownerTree);

        getContentPane().add(ownerLabel);
        ownerLabel.setBounds(0,0,495,30);

        getContentPane().add(ownerTree);
        ownerTree.setBounds(0,30,495,470);

        repaint();
    }

    public void drawShoe() {

        getContentPane().remove(shoeLabel);
        getContentPane().remove(shoeTree);

        getContentPane().add(shoeLabel);
        shoeLabel.setBounds(500,0,495,30);

        getContentPane().add(shoeTree);
        shoeTree.setBounds(500,30,495,470);

        repaint();
    }

    public void drawPopup(Object source) {

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem newJMenuItem = new JMenuItem("Add");
        popupMenu.add(newJMenuItem);

        popupMenu.show((JTree) source, 50, 0);
        popupMenu.setVisible(true);
    }
}
