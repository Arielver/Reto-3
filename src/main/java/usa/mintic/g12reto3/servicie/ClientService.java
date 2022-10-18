package usa.mintic.g12reto3.servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12reto3.entities.Client;
import usa.mintic.g12reto3.repositoy.crud.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    public Optional<Client> getById(int id) {
        return clientRepository.getById(id);
    }

    public Client save(Client cli) {
        if (cli.getIdClient() == null) {
            return clientRepository.save(cli);
        }
        return cli;
    }

    public boolean delete(int id) {
        Optional<Client> cOpt = clientRepository.getById(id);
        if (cOpt.isPresent()) {
            clientRepository.delete(cOpt.get());
            return true;
        }
        return false;
    }

    public Client update(Client cli) {
        if (cli.getIdClient() != null) {
            Optional<Client> oldCli = clientRepository.getById(cli.getIdClient());
            if (oldCli.isPresent()) {
                Client newcli = oldCli.get();
                if (cli.getEmail() != null) {
                    newcli.setEmail(cli.getEmail());
                }
                if (cli.getPassword() != null) {
                    newcli.setPassword(cli.getPassword());
                }
                if (cli.getName() != null) {
                    newcli.setName(cli.getName());
                }
                if (cli.getAge() != null) {
                    newcli.setAge(cli.getAge());
                }
                return clientRepository.save(newcli);
            }
        }
        return cli;
    }


}
