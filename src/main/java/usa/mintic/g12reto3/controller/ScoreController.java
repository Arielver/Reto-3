package usa.mintic.g12reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12reto3.entities.Client;
import usa.mintic.g12reto3.entities.Score;
import usa.mintic.g12reto3.servicie.ScoreService;

import java.util.List;

@RestController
@RequestMapping("/api/score")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll (){
        return scoreService.getAll();
    }
    @PostMapping("/save")
    public Score save (@RequestBody Score c){
        return scoreService.save(c);
    }
}
