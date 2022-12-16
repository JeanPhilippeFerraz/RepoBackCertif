package com.easychat.core.Controller;

import com.easychat.core.entity.Message;
import com.easychat.core.service.IMessageService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/easychat")
public class MessageController {

    private IMessageService service;

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> createMessage(Message message){
        return ResponseEntity.ok(service.createMessage(message));
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Message>> getAllMessages(){
        return ResponseEntity.ok(service.getAllMessage());
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> getMessageById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getMessageById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Message> updateMessage(Message message){
        try {
            return ResponseEntity.ok(service.updateMessage(message));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id){
        try {
            service.deleteMessage(service.getMessageById(id));
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
