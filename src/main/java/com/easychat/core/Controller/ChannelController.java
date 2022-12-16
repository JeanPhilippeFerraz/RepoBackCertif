package com.easychat.core.Controller;

import com.easychat.core.entity.Channel;
import com.easychat.core.service.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/easychat/channel")
public class ChannelController {

    @Autowired
    private IChannelService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Channel>> getAllChannels() {
        return ResponseEntity.ok(service.getAllChannels());
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Channel> getChannelById(@PathVariable Integer id) {
        try{
            return ResponseEntity.ok(service.getChannelById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Channel> createChannel(@RequestBody Channel channel) {
        return ResponseEntity.ok(service.createChannel(channel));
    }

    @DeleteMapping
    public ResponseEntity<Channel> deleteChannel(@RequestBody Channel channel) {
        if (channel.getId()!=1){
            try {
                service.deleteChannel(channel);
                return ResponseEntity.ok(channel);
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }

    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Channel> updateChannel(@RequestBody Channel channel) {
        try {
            return ResponseEntity.ok(service.updateChannel(channel));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
