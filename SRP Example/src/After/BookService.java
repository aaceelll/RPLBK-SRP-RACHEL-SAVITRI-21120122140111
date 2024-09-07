package After;

import java.util.ArrayList;
import java.util.List;

class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public void addBook(String title, int authorId) {
        Author author = authorService.findAuthorById(authorId);
        if (author == null) {
            System.out.println("Author not found");
            return;
        }
        Book book = new Book(title, author);
        bookRepository.save(book);
        System.out.println("Book added: " + book.getTitle());
    }
}

class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public void save(Book book) {
        books.add(book);
    }

    public List<Book> findAll() {
        return books;
    }
}

class AuthorRepository {
    private final List<Author> authors = new ArrayList<>();

    public void save(Author author) {
        authors.add(author);
    }

    public Author findById(int authorId) {
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


class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(String name, int authorId) {
        Author author = new Author(name, authorId);
        authorRepository.save(author);
        System.out.println("Author added: " + name);
    }

    public Author findAuthorById(int authorId) {
        return authorRepository.findById(authorId);
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
