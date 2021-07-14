package hu.ittc.training.dictionary.window;

import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.event.BookShelfMouseEventListener;
import hu.ittc.training.dictionary.window.event.BookTreeSelectionListener;
import hu.ittc.training.dictionary.window.event.OpenDocumentMouseEventListener;
import hu.ittc.training.dictionary.window.event.PopupMenuMouseEventListener;

import javax.swing.*;

public class MainFrame extends JFrame {

    private Shelf bookShelf;
    private Shelf dictionaryShelf;

    private JTextArea contentArea = new JTextArea();
    private JLabel contentLabel = new JLabel();
    private boolean treeVisible = false;

    public MainFrame(Shelf bookShelf, Shelf dictionaryShelf) {
        this.bookShelf = bookShelf;
        this.dictionaryShelf = dictionaryShelf;

        drawFrame();
    }

    private void drawFrame() {
        this.setTitle("Translator Application");
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file =  new JMenu("File");
        JMenuItem openBook = new JMenuItem("Open Book");
        openBook.addMouseListener(new OpenDocumentMouseEventListener(bookShelf, OpenDocumentMouseEventListener.DocumentType.BOOK, this));
        JMenuItem openDictionary = new JMenuItem("Open Dictionary");
        openDictionary.addMouseListener(new OpenDocumentMouseEventListener(dictionaryShelf, OpenDocumentMouseEventListener.DocumentType.DICTIONARY, this));
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
        this.getContentPane().setLayout(null);

        getContentPane().setLayout(null);
    }

    public void drawBookTree(boolean refresh) {
        if (refresh && !treeVisible)
            return;
        treeVisible = true;

        getContentPane().removeAll();

        JLabel label = new JLabel("Bookshelf");
        getContentPane().add(label);
        label.setBounds(0,0,495,30);

        JTree booktree = new JTree(bookShelf.getDocuments().toArray());
        getContentPane().add(booktree);
        booktree.setBounds(0,30,495,470);
        booktree.addTreeSelectionListener(new BookTreeSelectionListener(this));

        getContentPane().add(contentArea);
        contentArea.setBounds(505,30,495,470);
        contentArea.setVisible(false);

        getContentPane().add(contentLabel);
        contentLabel.setText("Content");
        contentLabel.setBounds(505,0,495,30);
        contentLabel.setVisible(true);

        repaint();
    }

    public Book searchBook(String bookName) {
        Book chosenBook = (Book) bookShelf.getDocument(bookName);
        showContentArea(chosenBook);
        return chosenBook;
    }

    public void showContentArea(Book book) {
        contentLabel.setText("Content of "+ book.getName());
        contentArea.setText("");
        for(String line: book.getBookContent())
            contentArea.append(line+"\n");
        contentArea.setVisible(true);
        repaint();
    }

    public void drawPopup(Object source, Book book) {

        JPopupMenu popupMenu = new JPopupMenu();

        for (Document dictionary : dictionaryShelf.getDocuments()) {

            JMenuItem newJMenuItem = new JMenuItem(dictionary.getName());
            newJMenuItem.addMouseListener(new PopupMenuMouseEventListener((Dictionary) dictionary, book, this));

            popupMenu.add(newJMenuItem);
        }
        popupMenu.show((JTree) source, 50, 0);
        popupMenu.setVisible(true);
    }

}
