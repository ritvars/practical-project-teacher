package library.domain.book;

import java.util.List;

import library.repository.CrudRepository;

public class BookRepository extends CrudRepository<Book> {

    private static final String HIBERNATE_SELECT_QUERY = "from Book";

    public Book findOne(Long id) {
        return super.findOne(id, Book.class);
    }

    List<Book> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Book.class);
    }
}
