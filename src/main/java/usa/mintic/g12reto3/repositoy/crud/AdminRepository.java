package usa.mintic.g12reto3.repositoy.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12reto3.entities.Admin;
import usa.mintic.g12reto3.repositoy.AdminCRUDRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class AdminRepository {

    @Autowired
    private AdminCRUDRepository adminCRUDRepository;

    public List<Admin> getAll() {
        return (List<Admin>) adminCRUDRepository.findAll();
    }

    public Optional<Admin> getById(int id) {
        return adminCRUDRepository.findById(id);
    }

    public Admin save(Admin a) {
        return adminCRUDRepository.save(a);
    }

    public void delete(Admin c) {
        adminCRUDRepository.delete(c);
    }

}
