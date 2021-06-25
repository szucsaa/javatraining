package hu.ittc.training.dictionary.model;

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
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Please type the english equivalent of " + words[i]);
                    trans = scanner.nextLine();
                    dictionary.addWordPair(words[i], trans);
                }
                sb.append((i==0?"":" ")+trans);
            }
            transcontent.add(sb.toString());
        }
        target.setBookContent(transcontent);
    }
}
