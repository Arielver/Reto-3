package usa.mintic.g12reto3.repositoy.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import usa.mintic.g12reto3.entities.Message;
import usa.mintic.g12reto3.repositoy.MessageCRUDRepository;

import java.util.List;
import java.util.Optional;


@Repository
public class MessageRepository {

    @Autowired
    private MessageCRUDRepository messageCRUDRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCRUDRepository.findAll();
    }

    public Optional<Message> getById(int id) {
        return messageCRUDRepository.findById(id);
    }

    public Message save(Message m) {
        return messageCRUDRepository.save(m);
    }

    public void delete(Message c) {
        messageCRUDRepository.delete(c);
    }
}
