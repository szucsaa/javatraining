package hu.ittc.training.dictionary.model;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private List<Document> documents =  new ArrayList<>();

    public boolean addDocument(Document document) {
        for (Document doc: documents) {
            if (doc.getName().equals(document.getName())) {
                return false;
            }
        }
        documents.add(document);
        return true;
    }

    public List<Document> getDocuments() {
        return new ArrayList<>(documents);
    }

    public Document getDocument(String name) {
        for (Document document : documents) {
            if (document.getName().equals(name)) {
                return document;
            }
        }
        return null;
    }

}
