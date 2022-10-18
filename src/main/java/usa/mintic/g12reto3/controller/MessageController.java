package usa.mintic.g12reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12reto3.entities.Client;
import usa.mintic.g12reto3.entities.Message;
import usa.mintic.g12reto3.servicie.MessageService;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll (){
        return messageService.getAll();
    }
    @PostMapping("/save")
    public Message save (@RequestBody Message c){
        return messageService.save(c);
    }
}
