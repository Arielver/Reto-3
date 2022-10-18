package usa.mintic.g12reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12reto3.entities.Audience;
import usa.mintic.g12reto3.servicie.AudienceService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Audience")

public class AudienceController {
    @Autowired
    private AudienceService audienceService;

    @GetMapping("/all")
    public List<Audience> getAll() {
        return audienceService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience c) {
        return audienceService.save(c);
    }

    @GetMapping("/{id}")
    public Optional<Audience> getById(@PathVariable("id") int idAudience) {
        return audienceService.getById(idAudience);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience update(@RequestBody Audience a) {
        return audienceService.update(a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return audienceService.delete(id);
    }

}
