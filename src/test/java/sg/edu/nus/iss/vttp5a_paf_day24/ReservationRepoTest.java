package sg.edu.nus.iss.vttp5a_paf_day24;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import sg.edu.nus.iss.vttp5a_paf_day24.model.Reservation;
import sg.edu.nus.iss.vttp5a_paf_day24.model.ReservationDetail;
import sg.edu.nus.iss.vttp5a_paf_day24.repository.ReservationRepo;
import sg.edu.nus.iss.vttp5a_paf_day24.model.Book;
import sg.edu.nus.iss.vttp5a_paf_day24.utils.Query;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ReservationRepoTest {

    @Autowired
    private ReservationRepo reservationRepo;

    @MockBean
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testCreateReservation() throws SQLException {
        Reservation reservation = new Reservation();
        reservation.setFullName("John Doe");
        reservation.setReservationDate(Date.valueOf("2023-10-10"));

        KeyHolder keyHolder = new GeneratedKeyHolder();
        keyHolder.getKeyList().add(Map.of("id", 1));

        when(jdbcTemplate.update(any(PreparedStatementCreator.class), any(KeyHolder.class)))
                .thenAnswer(invocation -> {
                    KeyHolder kh = invocation.getArgument(1);
                    kh.getKeyList().add(Map.of("id", 1));
                    return 1;
                });

        int reservationId = reservationRepo.createReservation(reservation);
        assertEquals(1, reservationId);
    }

    @Test
    public void testCreateReservationDetails() {
        Reservation reservation = new Reservation();
        reservation.setId(1);

        Book book = new Book();
        book.setId(1);

        ReservationDetail reservationDetail = new ReservationDetail();
        reservationDetail.setReservation(reservation);
        reservationDetail.setBook(book);

        when(jdbcTemplate.update(anyString(), anyInt(), anyInt())).thenReturn(1);

        Boolean result = reservationRepo.createReservationDetails(reservationDetail);
        assertTrue(result);
    }
}