package sg.edu.nus.iss.vttp5a_paf_day24.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.vttp5a_paf_day24.model.Reservation;
import sg.edu.nus.iss.vttp5a_paf_day24.model.ReservationDetail;
import sg.edu.nus.iss.vttp5a_paf_day24.utils.Query;

@Repository
public class ReservationRepo {
    
    @Autowired
    JdbcTemplate template;

    public int createReservation(Reservation reservation) {

        KeyHolder keyHolder = new GeneratedKeyHolder();

        PreparedStatementCreator psc = new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(Query.insertReservation, new String[] {"id"});
                ps.setString(1, reservation.getFullName());
                ps.setDate(2, reservation.getReservationDate());

                return ps;
            }
            
        };

        template.update(psc, keyHolder);

        // return the primary stored in the reference variable KeyHolder of the parameter template.update
        int iReservationId = keyHolder.getKey().intValue();

        return iReservationId;
    }

    public Boolean createReservationDetails(ReservationDetail reservationDetail) {

        int iUpdated = template.update(Query.insertReservationDetail, reservationDetail.getBook().getId(), reservationDetail.getReservation().getId());

        if (iUpdated > 0)
            return true;
        return false;
        
    }
}
