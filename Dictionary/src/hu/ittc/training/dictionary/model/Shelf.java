package hu.ittc.training.dictionary.model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<Document> documents =  new ArrayList<>();

    public void addDocument(Document document) {
        documents.add(document);
    }

    public List<Document> getDocuments() {
        return new ArrayList<>(documents);
    }

}
