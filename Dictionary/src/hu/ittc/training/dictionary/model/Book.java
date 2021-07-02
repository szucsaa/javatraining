package hu.ittc.training.dictionary.model;

import java.util.List;

public class Book {

    private String name;

    private List<String> bookContent;

    public List<String> getBookContent() {
        return bookContent;
    }

    public void setBookContent(List<String> bookContent) {
        this.bookContent = bookContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return name;
    }

}
