package hu.ittc.training.dictionary.window;

import hu.ittc.training.dictionary.io.ModelIOHandler;
import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.event.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainFrame extends JFrame {

    private Shelf bookShelf;
    private Shelf dictionaryShelf;

    private ModelIOHandler modelIOHandler = new ModelIOHandler();

    private JTextArea contentArea = new JTextArea();
    private JLabel contentLabel = new JLabel();
    private JButton saveIcon = new JButton();
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
        openBook.addMouseListener(new OpenDocumentMouseEventListener(bookShelf, Document.DocumentType.BOOK, this));
        JMenuItem openDictionary = new JMenuItem("Open Dictionary");
        openDictionary.addMouseListener(new OpenDocumentMouseEventListener(dictionaryShelf, Document.DocumentType.DICTIONARY, this));
        JMenuItem saveDictionaries = new JMenuItem("Save Dictionaries");
        saveDictionaries.addMouseListener(new SaveDictionariesMouseEventListener(dictionaryShelf));
        file.add(openBook);
        file.add(openDictionary);
        file.add(saveDictionaries);
        JMenu translate =  new JMenu("Translate");
        JMenuItem bookshelf = new JMenuItem("Bookshelf");
        translate.add(bookshelf);
        bookshelf.addMouseListener(new ShelfMouseEventListener(this, Document.DocumentType.BOOK));
        JMenuItem dictshelf = new JMenuItem("Dict.shelf");
        translate.add(dictshelf);
        dictshelf.addMouseListener(new ShelfMouseEventListener(this, Document.DocumentType.DICTIONARY));
        jMenuBar.add(file);
        jMenuBar.add(translate);
        this.setJMenuBar(jMenuBar);
        this.setSize(1000, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.getContentPane().setLayout(null);

        this.setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        contentArea.addKeyListener(new TextChangeEventListener(saveIcon));
    }

    public void drawBookTree(Document.DocumentType documentType, boolean refresh) {
        if (refresh && !treeVisible)
            return;
        treeVisible = true;

        getContentPane().removeAll();

        JLabel label = new JLabel((documentType == Document.DocumentType.BOOK?"Book":"Dictionary")+"shelf");
        getContentPane().add(label);
        label.setBounds(0,0,495,30);

        JTree docTree = new JTree((documentType == Document.DocumentType.BOOK?bookShelf:dictionaryShelf).getDocuments().toArray());
        getContentPane().add(docTree);
        docTree.setBounds(0,30,495,470);
        docTree.addMouseListener(new DocMouseListener(docTree,this,documentType));

        getContentPane().add(contentArea);
        contentArea.setBounds(505,30,495,470);
        contentArea.setVisible(false);

        getContentPane().add(contentLabel);
        contentLabel.setText("Content");
        contentLabel.setBounds(505,0,495,30);
        contentLabel.setVisible(true);

        getContentPane().add(saveIcon);
        saveIcon.setIcon(UIManager.getIcon("FileView.floppyDriveIcon"));
//        File file = new File(getClass().getClassLoader().getResource("save1600.png").getFile());
//        saveIcon.setIcon(new ImageIcon(file.getAbsolutePath()));
        saveIcon.setBounds(950,0,30,30);
        saveIcon.setVisible(false);

        repaint();
    }

    public Document pickDoc(String docName, Document.DocumentType docType) {
        Document chosenDoc = ((docType == Document.DocumentType.BOOK)?bookShelf:dictionaryShelf).getDocument(docName);
        showContentArea(chosenDoc, false);
        return chosenDoc;
    }

    public void showContentArea(Document doc, boolean saveEnabled) {
        contentLabel.setText("Content of "+ doc.getName());
        contentArea.setText("");
        for(String line: doc.getContentAsList())
            contentArea.append(line+"\n");
        contentArea.setVisible(true);
        for(ActionListener al: saveIcon.getActionListeners())
            saveIcon.removeActionListener(al);

        saveIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doc.setContentAsList(Arrays.asList(contentArea.getText().split("\n")));
                String message = null;
                if (doc instanceof Book) {
                    modelIOHandler.writeBookContent((Book) doc);
                    message = "Book saved!";
                }
                if (doc instanceof Dictionary) {
                    modelIOHandler.writeDictionary((Dictionary) doc);
                    message = "Dictionary saved!";
                }
                JOptionPane.showMessageDialog(null,message);
                saveIcon.setEnabled(false);
            }
        });

        /* with lambda :)
        saveIcon.addActionListener(e -> {
            modelIOHandler.writeBookContent(book);
            JOptionPane.showMessageDialog(null,"Book saved!");
        });
         */

        saveIcon.setVisible(true);
        saveIcon.setEnabled(saveEnabled);
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
