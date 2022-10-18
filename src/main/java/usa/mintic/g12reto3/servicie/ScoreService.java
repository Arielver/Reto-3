package usa.mintic.g12reto3.servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12reto3.entities.Score;
import usa.mintic.g12reto3.repositoy.crud.ScoreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();
    }

    public Optional<Score> getById(int id) {
        return scoreRepository.getById(id);
    }

    public Score save(Score mess) {
        if (mess.getId() == null) {
            return scoreRepository.save(mess);
        }
        return mess;
    }

    public boolean delete(int id) {
        Optional<Score> scOpt = scoreRepository.getById(id);
        if (scOpt.isPresent()) {
            scoreRepository.delete(scOpt.get());
            return true;
        }
        return false;
    }

    public Score update(Score sc) {
        if (sc.getScore() != null) {
            Optional<Score> oldSc = scoreRepository.getById(sc.getId());
            if (oldSc.isPresent()) {
                Score newSc = oldSc.get();
                if (sc.getScore() != null) {
                    newSc.setScore(sc.getScore());
                }
                if (sc.getMessageText() != null) {
                    newSc.setMessageText(sc.getMessageText());
                }
                return scoreRepository.save(newSc);
            }
        }
        return sc;
    }
}
