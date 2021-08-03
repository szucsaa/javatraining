package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.io.ModelIOHandler;
import hu.ittc.training.dictionary.model.Book;
import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Shelf;
import hu.ittc.training.dictionary.window.MainFrame;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class OpenDocumentMouseEventListener implements MouseListener {

    private JFileChooser jFileChooser = new JFileChooser();
    private ModelIOHandler modelIOHandler = new ModelIOHandler();
    private Shelf shelf;
    private Document.DocumentType type;
    private MainFrame mainFrame;

    public OpenDocumentMouseEventListener(Shelf shelf, Document.DocumentType type, MainFrame mainFrame) {
        this.shelf=shelf;
        this.type=type;
        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (jFileChooser.showOpenDialog(e.getComponent()) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File selectedFile = jFileChooser.getSelectedFile();
        Document document = null;
        if (type == Document.DocumentType.BOOK) {
            document = new Book();
            modelIOHandler.readBookContent((Book)document, selectedFile);
        }
        if (type == Document.DocumentType.DICTIONARY) {
            document = new Dictionary();
            modelIOHandler.readDictionaryFile((Dictionary) document, selectedFile);
        }

        boolean success = shelf.addDocument(document);

        JOptionPane.showMessageDialog(null, success ? "Document " + document.getName() + " was added!" : "A document with this name already exist!");


        mainFrame.drawBookTree(type,true);
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
