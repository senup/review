package github.io.review.reflect;

public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    private String secret() {
        return "The secret of the book is patience.";
    }
}