package usa.mintic.g12reto3.repositoy;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.g12reto3.entities.Client;

public interface ClientCRUDRepository extends CrudRepository<Client, Integer> {
}
