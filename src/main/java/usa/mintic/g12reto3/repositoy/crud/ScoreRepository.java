package usa.mintic.g12reto3.repositoy.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12reto3.entities.Score;
import usa.mintic.g12reto3.repositoy.ScoreCRUDRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCRUDRepository scoreCRUDRepository;

    public List<Score> getAll() {
        return (List<Score>) scoreCRUDRepository.findAll();
    }

    public Optional<Score> getById(int id) {
        return scoreCRUDRepository.findById(id);
    }

    public Score save(Score s) {
        return scoreCRUDRepository.save(s);
    }

    public void delete(Score c) {
        scoreCRUDRepository.delete(c);
    }
}
