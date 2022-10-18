package usa.mintic.g12reto3.repositoy.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12reto3.entities.Audience;
import usa.mintic.g12reto3.repositoy.AudienceCRUDRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AudienceRepository {

    @Autowired
    private AudienceCRUDRepository audienceCRUDRepository;

    public List<Audience> getAll() {
        return (List<Audience>) audienceCRUDRepository.findAll();
    }

    public Optional<Audience> getById(int id) {
        return audienceCRUDRepository.findById(id);
    }

    public Audience save(Audience a) {
        return audienceCRUDRepository.save(a);
    }

    public void delete(Audience c) {
        audienceCRUDRepository.delete(c);
    }
}
