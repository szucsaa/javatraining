package hu.ittc.training.dictionary.model;

import java.util.List;

public class Book extends Document {


    private List<String> bookContent;

    public List<String> getBookContent() {
        return bookContent;
    }

    public void setBookContent(List<String> bookContent) {
        this.bookContent = bookContent;
    }

    public String toString(){
        return name;
    }

}
