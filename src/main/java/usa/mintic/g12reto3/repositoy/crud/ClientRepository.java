package usa.mintic.g12reto3.repositoy.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12reto3.entities.Client;
import usa.mintic.g12reto3.repositoy.ClientCRUDRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCRUDRepository clientCRUDRepository;

    public List<Client> getAll() {
        return (List<Client>) clientCRUDRepository.findAll();
    }

    public Optional<Client> getById(int id) {
        return clientCRUDRepository.findById(id);
    }

    public Client save(Client c) {
        return clientCRUDRepository.save(c);
    }

    public void delete(Client c) {
        clientCRUDRepository.delete(c);
    }

}
