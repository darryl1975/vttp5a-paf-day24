package sg.edu.nus.iss.vttp5a_paf_day24.repository;

import java.beans.BeanProperty;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_paf_day24.model.Book;
import sg.edu.nus.iss.vttp5a_paf_day24.model.exception.BookNotFoundException;
import sg.edu.nus.iss.vttp5a_paf_day24.utils.Query;

@Repository
public class BookRepo {
    
    @Autowired
    JdbcTemplate template;

    public Boolean insertBook(Book book) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Query.createBookSql, new String[] {"id"});
                ps.setString(1, book.getTitle());
                ps.setInt(2, book.getQuantity());

                return ps;
            }
            
        };

        int createdBookId = template.update(psc, keyHolder);

        if (createdBookId > 0)
            return true;
        return false;
    }

    public List<Book> getAllBooks() {
        List<Book> books = template.query(Query.getBooksSql, BeanPropertyRowMapper.newInstance(Book.class));

        if (books.isEmpty()) {
            throw new BookNotFoundException("No found in reserved");
        }

        return books;
    }

    public Book getBookById(int bookId) {
        Book book =  null;
        
        try {
            book = template.queryForObject(Query.getBookById, BeanPropertyRowMapper.newInstance(Book.class), bookId);
        } catch (DataAccessException ex) {
            throw new BookNotFoundException("Book Not Found!!!");
        }


        return book;
    }

    public Boolean updateBook(Book book) {
        int bUpdated = template.update(Query.updateBookById, book.getTitle(), book.getQuantity(), book.getId());

        if (bUpdated > 0)
            return true;
        return false;
    }

    public Boolean updateBookStatus(Book book) {
        int bUpdated = template.update(Query.updateBookStatusById, book.getIsActive(), book.getId());

        if (bUpdated > 0)
            return true;
        return false;
    } 
}
