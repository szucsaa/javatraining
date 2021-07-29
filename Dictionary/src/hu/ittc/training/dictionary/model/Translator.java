package hu.ittc.training.dictionary.model;

import hu.ittc.training.dictionary.window.TranslateDialog;

import java.util.ArrayList;
import java.util.Scanner;

public class Translator {

    private Dictionary dictionary;

    public Translator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void translate(Book source, Book target){
        ArrayList<String> transcontent = new ArrayList<>();
        for(String line: source.getBookContent()) {
            String[] words = line.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                String trans = dictionary.getTranslation(words[i]);
                if (trans == null) {
                    TranslateDialog tdialog = new TranslateDialog(words[i]);
                    tdialog.setVisible(true);
                    trans = tdialog.getTranslatedWord();
                    dictionary.addWordPair(words[i], trans);
                }
                sb.append((i==0?"":" ")+trans);
            }
            transcontent.add(sb.toString());
        }
        target.setBookContent(transcontent);
    }
}
