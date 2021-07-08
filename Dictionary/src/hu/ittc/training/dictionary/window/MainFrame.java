package hu.ittc.training.dictionary.window;

import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.event.BookShelfMouseEventListener;
import hu.ittc.training.dictionary.window.event.BookTreeSelectionListener;
import hu.ittc.training.dictionary.window.event.OpenDocumentMouseEventListener;

import javax.swing.*;

public class MainFrame extends JFrame {

    private Shelf bookShelf;
    private Shelf dictionaryShelf;

    private JTextArea contentArea = new JTextArea();
    private JLabel contentLabel = new JLabel("Content");

    public MainFrame(Shelf bookShelf, Shelf dictionaryShelf) {
        this.bookShelf = bookShelf;
        this.dictionaryShelf = dictionaryShelf;

        drawFrame();
    }

    private void drawFrame() {
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file =  new JMenu("File");
        JMenuItem openBook = new JMenuItem("Open Book");
        openBook.addMouseListener(new OpenDocumentMouseEventListener(bookShelf, OpenDocumentMouseEventListener.DocumentType.BOOK));
        JMenuItem openDictionary = new JMenuItem("Open Dictionary");
        openDictionary.addMouseListener(new OpenDocumentMouseEventListener(dictionaryShelf, OpenDocumentMouseEventListener.DocumentType.DICTIONARY));
        file.add(openBook);
        file.add(openDictionary);
        JMenu translate =  new JMenu("Translate");
        JMenuItem bookshelf = new JMenuItem("Bookshelf");
        translate.add(bookshelf);
        bookshelf.addMouseListener(new BookShelfMouseEventListener(this));
        jMenuBar.add(file);
        jMenuBar.add(translate);

        this.setJMenuBar(jMenuBar);
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void drawBookTree() {
        getContentPane().removeAll();

        JLabel label = new JLabel("Bookshelf");
        label.setBounds(0,0,100,20);
        getContentPane().add(label);

        JTree booktree = new JTree(bookShelf.getDocuments().toArray());
        booktree.setBounds(0,20,500,500);
        booktree.addTreeSelectionListener(new BookTreeSelectionListener(this, bookShelf));
        getContentPane().add(booktree);

        contentArea.setBounds(510,20,490,500);
        contentArea.setVisible(false);
        getContentPane().add(contentArea);

        contentLabel.setBounds(510,0,100,20);
        contentLabel.setVisible(true);
        getContentPane().add(contentLabel);

        repaint();
    }

    public void showContentArea(String bookName) {
        contentLabel.setName("Content of "+bookName);
        contentLabel.setVisible(true);
        contentArea.setText("");
        contentArea.setVisible(true);
        repaint();
    }

    public void drawPopup(Object source) {
        JPopupMenu popupMenu = new JPopupMenu();
        for (Document dictionary : dictionaryShelf.getDocuments()) {
            JMenuItem newJMenuItem = new JMenuItem(dictionary.getName());
            popupMenu.add(newJMenuItem);
        }
        popupMenu.show((JTree) source, 50, 0);
        popupMenu.setVisible(true);
    }

    public void appendContentLine(String line) {
        contentArea.append(line+"\n");
    }
}
