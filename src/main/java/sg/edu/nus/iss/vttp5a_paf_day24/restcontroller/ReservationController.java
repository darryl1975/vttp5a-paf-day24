package sg.edu.nus.iss.vttp5a_paf_day24.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.vttp5a_paf_day24.model.ReservationDetail;
import sg.edu.nus.iss.vttp5a_paf_day24.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("")
    public ResponseEntity<Boolean> makeReservation(@RequestBody ReservationDetail reservation) {
        Boolean bCreated = reservationService.createReservationRecord(reservation.getReservation(), reservation);
        
        return ResponseEntity.ok().body(bCreated);
    }
    


}
