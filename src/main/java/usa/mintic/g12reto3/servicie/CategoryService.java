package usa.mintic.g12reto3.servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12reto3.entities.Category;
import usa.mintic.g12reto3.repositoy.crud.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getById(int id) {
        return categoryRepository.getById(id);
    }

    public Category save(Category cat) {
        if (cat.getId() == null) {
            return categoryRepository.save(cat);
        }
        return cat;
    }

    public boolean delete(int id) {
        Optional<Category> cOpt = categoryRepository.getById(id);
        if (cOpt.isPresent()) {
            categoryRepository.delete(cOpt.get());
            return true;
        }
        return false;
    }

    public Category update(Category cat) {
        if (cat.getId() != null) {
            Optional<Category> oldCat = categoryRepository.getById(cat.getId());
            if (oldCat.isPresent()) {
                Category newCat = oldCat.get();
                if (cat.getName() != null) {
                    newCat.setName(cat.getName());
                }
                if (cat.getDescription() != null) {
                    newCat.setDescription(cat.getDescription());
                }
                return categoryRepository.save(newCat);
            }
        }
        return cat;
    }
}
