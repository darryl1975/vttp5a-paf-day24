package sg.edu.nus.iss.vttp5a_paf_day24.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    private int id;

    private String fullName;

    private Date reservationDate;
    
}
