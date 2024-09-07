package Before;

import java.util.ArrayList;
import java.util.List;

class BookService {
    private final List<Book> books = new ArrayList<>();
    private final List<Author> authors = new ArrayList<>();

    public void addBook(String title, int authorId) {
        Author author = findAuthorById(authorId);
        if (author == null) {
            System.out.println("Author not found");
            return;
        }
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addAuthor(String name, int authorId) {
        Author author = new Author(name, authorId);
        authors.add(author);
        System.out.println("Author added: " + name);
    }

    private Author findAuthorById(int authorId) {
        for (Author author : authors) {
            if (author.getAuthorId() == authorId) {
                return author;
            }
        }
        return null;
    }
}

class Book {
    private String title;
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }
}

class Author {
    private String name;
    private int authorId;

    public Author(String name, int authorId) {
        this.name = name;
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public int getAuthorId() {
        return authorId;
    }
}