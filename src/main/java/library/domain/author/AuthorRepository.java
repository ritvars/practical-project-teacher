package library.domain.author;

import java.util.List;

import library.repository.CrudRepository;

public class AuthorRepository extends CrudRepository<Author> {

    private static final String HIBERNATE_SELECT_QUERY = "from Author";

    private static final String AUTHOR_ID_PARAM = ":authorId";
    private static final String DELETE_QUERY = "delete from Author author where author.id = " + AUTHOR_ID_PARAM;

    public void delete(Long id) {
        runInTransaction((session) ->
                session.createQuery(DELETE_QUERY)
                        .setParameter(AUTHOR_ID_PARAM, id)
                        .executeUpdate());
    }

    public Author findOne(Long id) {
        return super.findOne(id, Author.class);
    }

    public List<Author> findAll() {
        return super.findAll(HIBERNATE_SELECT_QUERY, Author.class);
    }
}
