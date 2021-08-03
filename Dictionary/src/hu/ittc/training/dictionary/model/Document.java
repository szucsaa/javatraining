package hu.ittc.training.dictionary.model;

import java.util.List;

public abstract class Document {
    public enum DocumentType {
        BOOK,
        DICTIONARY
    }

    protected String name;
    protected String path;

    public String getName() {
        return name;
    }
    public String getPath() {
        return path;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPath(String path) {
        this.path = path;
    }

    public abstract List<String> getContentAsList();
    public abstract void setContentAsList(List<String> content);
}
