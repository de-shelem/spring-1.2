package ua.khai.shelemonchak.application.dao;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ua.khai.shelemonchak.application.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao{


    private final JdbcOperations jdbc;
    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    public BookDaoJdbc(NamedParameterJdbcOperations namedParameterJdbcOperations)
    {

        this.jdbc = namedParameterJdbcOperations.getJdbcOperations();
        this.namedParameterJdbcOperations = namedParameterJdbcOperations;
    }


    public int count() {
        return jdbc.queryForObject("select count(*) from book", Integer.class);
    }


    public void insert(Book book) {
        jdbc.update("insert into book (id, `name`, `author`, `genre`) values (?, ?, ?, ?)", book.getId(), book.getName(), book.getAuthor(),book.getGenre());
    }


    public Book getById(int id)    {
        Map<String, Object> params = Collections.singletonMap("id", id);
        try {

            return namedParameterJdbcOperations.queryForObject(
                    "select * from book where id = :id", params, new BookMapper()
            );
        }catch (Exception ex){
            return null;
        }
    }


    public List<Book> getAll() {
        return jdbc.query("select * from book", new BookMapper());
    }


    public void deleteById(int id) {
        Map<String, Object> params = Collections.singletonMap("id", id);

        namedParameterJdbcOperations.update("delete from book where id = :id", params);
    }

    private static class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String author = resultSet.getString("author");
            String genre = resultSet.getString("genre");
            return new Book(id, name,author,genre);
        }
    }

}
