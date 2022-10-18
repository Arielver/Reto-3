package usa.mintic.g12reto3.servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12reto3.entities.Admin;
import usa.mintic.g12reto3.repositoy.crud.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getById(int id) {
        return adminRepository.getById(id);
    }

    public Admin save(Admin adm) {
        if (adm.getId() == null) {
            return adminRepository.save(adm);
        }
        return adm;
    }

    public boolean delete(int id) {
        Optional<Admin> admOpt = adminRepository.getById(id);
        if (admOpt.isPresent()) {
            adminRepository.delete(admOpt.get());
            return true;
        }
        return false;
    }

    public Admin update(Admin adm) {
        if (adm.getId() != null) {
            Optional<Admin> oldAdm = adminRepository.getById(adm.getId());
            if (oldAdm.isPresent()) {
                Admin newAdm = oldAdm.get();
                if (adm.getName() != null) {
                    newAdm.setName(adm.getName());
                }
                if (adm.getPassword() != null) {
                    newAdm.setPassword(adm.getPassword());
                }
                if (adm.getEmail() != null) {
                    newAdm.setEmail(adm.getEmail());
                }
                return adminRepository.save(newAdm);
            }
        } return adm;
    }
}
