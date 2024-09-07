package After;

public class Main {
    public static void main(String[] args) {
        // Membuat instance dari repository dan service
        BookRepository bookRepository = new BookRepository();
        AuthorRepository authorRepository = new AuthorRepository();
        AuthorService authorService = new AuthorService(authorRepository);
        BookService bookService = new BookService(bookRepository, authorService);

        // Menambahkan beberapa penulis
        authorService.addAuthor("J.K. Rowling", 1);
        authorService.addAuthor("George R.R. Martin", 2);

        // Menambahkan beberapa buku
        bookService.addBook("Harry Potter", 1);  // Penulis: J.K. Rowling
        bookService.addBook("Game of Thrones", 2);  // Penulis: George R.R. Martin
        bookService.addBook("Unknown Book", 3);  // Author ID: 3 -> Tidak ditemukan

        // Mencoba menambahkan buku tanpa penulis yang valid
        bookService.addBook("Another Unknown Book", 4);  // Author ID: 4 -> Tidak ditemukan
    }
}