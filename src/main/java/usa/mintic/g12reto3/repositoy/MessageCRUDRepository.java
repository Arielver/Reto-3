package usa.mintic.g12reto3.repositoy;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.g12reto3.entities.Message;

public interface MessageCRUDRepository extends CrudRepository<Message, Integer> {
}
