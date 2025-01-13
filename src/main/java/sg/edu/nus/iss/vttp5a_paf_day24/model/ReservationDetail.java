package sg.edu.nus.iss.vttp5a_paf_day24.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDetail {
    
    private int id;

    private Book book;

    private Reservation reservation;
}
