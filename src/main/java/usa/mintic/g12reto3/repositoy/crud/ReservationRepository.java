package usa.mintic.g12reto3.repositoy.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12reto3.entities.Reservation;
import usa.mintic.g12reto3.repositoy.ReservationCRUDRespository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCRUDRespository reservationCRUDRespository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCRUDRespository.findAll();
    }

    public Optional<Reservation> getById(int id) {
        return reservationCRUDRespository.findById(id);
    }

    public Reservation save(Reservation r) {
        return reservationCRUDRespository.save(r);
    }

    public void delete(Reservation c) {
        reservationCRUDRespository.delete(c);
    }

}
