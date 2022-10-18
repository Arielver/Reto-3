package usa.mintic.g12reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12reto3.entities.Client;
import usa.mintic.g12reto3.entities.Reservation;
import usa.mintic.g12reto3.servicie.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll (){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    public Reservation save (@RequestBody Reservation c){
        return reservationService.save(c);
    }

}
