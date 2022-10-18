package usa.mintic.g12reto3.servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12reto3.entities.Reservation;
import usa.mintic.g12reto3.repositoy.crud.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getById(int id) {
        return reservationRepository.getById(id);
    }

    public Reservation save(Reservation res) {
        if (res.getIdReservation() == null) {
            return reservationRepository.save(res);
        }
        return res;
    }

    public boolean delete(int id) {
        Optional<Reservation> rOp = reservationRepository.getById(id);
        if (rOp.isPresent()) {
            reservationRepository.delete(rOp.get());
            return true;
        }
        return false;
    }

    public Reservation update(Reservation res) {
        if (res.getIdReservation() != null) {
            Optional<Reservation> oldRes = reservationRepository.getById(res.getIdReservation());
            if (oldRes.isPresent()) {
                Reservation newRes = oldRes.get();
                if (res.getStarDate() != null) {
                    newRes.setStarDate(res.getStarDate());
                }
                if (res.getDevolutionDate() != null) {
                    newRes.setDevolutionDate(res.getDevolutionDate());
                }
                if (res.getStatus() != null) {
                    newRes.setStatus(res.getStatus());
                }
                return reservationRepository.save(newRes);
            }
        }
        return res;
    }

}