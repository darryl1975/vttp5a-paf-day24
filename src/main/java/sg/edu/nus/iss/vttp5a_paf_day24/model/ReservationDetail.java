package sg.edu.nus.iss.vttp5a_paf_day24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDetail {
    
    // auto generated (increment in DB)
    private int id;

    // must a valid book record
    private Book book;

    // no information on create new
    private Reservation reservation;
}
