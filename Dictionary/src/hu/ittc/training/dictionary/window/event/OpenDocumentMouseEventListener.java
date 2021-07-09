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
    private DocumentType type;
    private MainFrame mainFrame;

    public OpenDocumentMouseEventListener(Shelf shelf, DocumentType type, MainFrame mainFrame) {
        this.shelf=shelf;
        this.type=type;
        this.mainFrame = mainFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        jFileChooser.showOpenDialog(e.getComponent());
        File selectedFile = jFileChooser.getSelectedFile();
        Document document;
        if (type == DocumentType.BOOK) {
            document = new Book();
            modelIOHandler.readBookContent((Book)document, selectedFile);
        } else {
            document=new Dictionary();
            modelIOHandler.readDictionaryFile((Dictionary) document, selectedFile);
        }
        shelf.addDocument(document);

        mainFrame.drawBookTree(true);
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

    public enum DocumentType {
        BOOK,
        DICTIONARY
    }
}
