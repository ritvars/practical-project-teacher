package library.domain.book;

import library.domain.author.Author;
import library.domain.author.AuthorRepository;

public class DummyData {

    private Integer ID = 1;

    private AuthorRepository authorRepository = new AuthorRepository();
    private BookRepository bookRepository = new BookRepository();

    public void insert() {
        int limit = 10;
        for (int i = 0; i < limit; i++, ID++) {
            Author author = author();
            authorRepository.save(author);
            Book book = book(author);
            bookRepository.save(book);
        }
    }

    private Author author() {
        return new Author("Name " + ID, "Surname " + ID);
    }

    private Book book(Author author) {
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle("Title " + ID);
        book.setDescription("Description " + ID);
        return book;
    }
}
