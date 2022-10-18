package usa.mintic.g12reto3.servicie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usa.mintic.g12reto3.entities.Message;
import usa.mintic.g12reto3.repositoy.crud.MessageRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> getById(int id) {
        return messageRepository.getById(id);
    }

    public Message save(Message mess) {
        if (mess.getId() == null) {
            return messageRepository.save(mess);
        }
        return mess;
    }

    public boolean delete(int id) {
        Optional<Message> messOpt = messageRepository.getById(id);
        if (messOpt.isPresent()) {
            messageRepository.delete(messOpt.get());
            return true;
        }
        return false;
    }

    public Message update(Message mess) {
        if (mess.getId() != null) {
            Optional<Message> oldMess = messageRepository.getById(mess.getId());
            if (oldMess.isPresent()) {
                Message newMess = oldMess.get();
                if (mess.getMessageText() != null) {
                    newMess.setMessageText(mess.getMessageText());
                }
                return messageRepository.save(newMess);
            }
        }
        return mess;
    }
}
