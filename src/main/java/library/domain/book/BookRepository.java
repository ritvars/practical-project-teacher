package library.domain.book;

import java.util.List;

import library.repository.CrudRepository;

public class BookRepository extends CrudRepository<Book> {

    private static final String HIBERNATE_SELECT_QUERY = "from Book";

    private static final String ID_PARAM = ":bookId";
    private static final String DELETE_QUERY = "delete from Book book where book.id = " + ID_PARAM;

    public void delete(Long id) {
        runInTransaction((session) ->
                session.createQuery(DELETE_QUERY)
                        .setParameter(ID_PARAM, id)
                        .executeUpdate());
    }

    public Book findOne(Long id) {
        return super.findOne(id, Book.class);
    }

    List<Book> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Book.class);
    }
}
