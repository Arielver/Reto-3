package usa.mintic.g12reto3.servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12reto3.entities.Audience;
import usa.mintic.g12reto3.repositoy.crud.AudienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll() {
        return audienceRepository.getAll();
    }

    public Optional<Audience> getById(int id) {
        return audienceRepository.getById(id);
    }

    public Audience save(Audience aud) {
        if (aud.getId() == null) {
            return audienceRepository.save(aud);
        }
        return aud;
    }

    public boolean delete(int id) {
        Optional<Audience> cOp = audienceRepository.getById(id);
        if (cOp.isPresent()) {
            audienceRepository.delete(cOp.get());
            return true;
        }
        return false;
    }

    public Audience update(Audience aud) {
        if (aud.getId() != null) {
            Optional<Audience> oldAud = audienceRepository.getById(aud.getId());
            if (oldAud.isPresent()) {
                Audience newAud = oldAud.get();
                if (aud.getName() != null) {
                    newAud.setName(aud.getName());
                }
                if (aud.getDescription() != null) {
                    newAud.setDescription(aud.getDescription());
                }
                if (aud.getOwner() != null) {
                    newAud.setOwner(aud.getOwner());
                }
                if (aud.getCapacity() != null) {
                    newAud.setCapacity(aud.getCapacity());
                }
                if (aud.getCategory() != null) {
                    newAud.setCategory(aud.getCategory());
                }
                return audienceRepository.save(newAud);
            }
        }
        return aud;
    }
}
