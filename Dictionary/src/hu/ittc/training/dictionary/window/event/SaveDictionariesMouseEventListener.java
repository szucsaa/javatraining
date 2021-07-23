package hu.ittc.training.dictionary.window.event;

import hu.ittc.training.dictionary.model.Dictionary;
import hu.ittc.training.dictionary.model.Document;
import hu.ittc.training.dictionary.model.Shelf;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SaveDictionariesMouseEventListener implements MouseListener {
    private Shelf dictionaryShelf;
    public SaveDictionariesMouseEventListener(Shelf dictionaryShelf) {
        this.dictionaryShelf=dictionaryShelf;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        dictionaryShelf.getDocuments().forEach((Document dict)->((Dictionary)dict).saveDictionary());
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
