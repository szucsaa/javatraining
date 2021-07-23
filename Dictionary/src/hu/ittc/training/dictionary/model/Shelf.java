package hu.ittc.training.dictionary.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Shelf {
    private List<Document> documents =  new ArrayList<>();

    public boolean addDocument(Document document) {
        Optional<Document> docAlreadyThere=documents.stream().filter(doc->doc.getName().equals(document.getName())).findAny();
        if (docAlreadyThere.isPresent()) return false;
        /*
        for (Document doc: documents) {
            if (doc.getName().equals(document.getName())) {
                return false;
            }
        }
         */
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
