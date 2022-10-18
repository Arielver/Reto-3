package usa.mintic.g12reto3.repositoy;

import org.springframework.data.repository.CrudRepository;
import usa.mintic.g12reto3.entities.Category;

public interface CategoryCRUDRepository extends CrudRepository<Category, Integer> {
}
