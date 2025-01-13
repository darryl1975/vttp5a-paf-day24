package sg.edu.nus.iss.vttp5a_paf_day24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.edu.nus.iss.vttp5a_paf_day24.model.Reservation;
import sg.edu.nus.iss.vttp5a_paf_day24.model.ReservationDetail;
import sg.edu.nus.iss.vttp5a_paf_day24.repository.ReservationRepo;

@Service
public class ReservationService {

    @Autowired
    ReservationRepo reservationRepo;

    @Transactional
    public boolean createReservationRecord(Reservation reservation, ReservationDetail reservationDetail) {

        Boolean bCreated = false;
        // start transaction
        // already in transaction based on the @Transactional annotation.

        // create the reservation record
        reservationRepo.createReservation(reservation);

        // uncomment to simulate error
        // throw new IllegalArgumentException("Simulate error after creating Reservation...");

        // created the reservation detail record
        reservationRepo.createReservationDetails(reservationDetail);

        // uncomment to simulate error
        // throw new IllegalArgumentException("Simulate error after creating ReservationDetails...");

        // commit transaction
        // auto because already annotated
        bCreated = true;

        return bCreated;
    }
    
}
