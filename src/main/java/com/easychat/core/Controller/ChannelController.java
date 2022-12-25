package com.easychat.core.Controller;

import com.easychat.core.Controller.dto.ChannelDto;
import com.easychat.core.entity.Channel;
import com.easychat.core.mapper.ChannelMapper;
import com.easychat.core.service.IChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/easychat/channel")
public class ChannelController {

    @Autowired
    private IChannelService service;

    @Autowired
    protected ChannelMapper mapper;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<ChannelDto>> getAllChannels() {

        return ResponseEntity.ok( service.getAllChannels().stream()
                                  .map(mapper::mapChannelToChannelDto)
                                  .collect(Collectors.toList()));
    }

    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ChannelDto> getChannelById(@PathVariable Integer id) {
        try{
            ChannelDto channelDto = mapper.mapChannelToChannelDto(service.getChannelById(id));
            return ResponseEntity.ok(channelDto);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ChannelDto> createChannel(@RequestBody ChannelDto channelDto) {
        Channel createdChannel = service.createChannel(mapper.mapChannelDtoToChannel(channelDto));
        return ResponseEntity.ok(mapper.mapChannelToChannelDto(createdChannel));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteChannel(@RequestBody ChannelDto channelDto) {

        Channel channel = mapper.mapChannelDtoToChannel(channelDto);
        if (channel.getId()!=1){
            try {
                service.deleteChannel(channel);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @PutMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ChannelDto> updateChannel(@RequestBody ChannelDto channelDto) {
        try {
            Channel channelUpdated = mapper.mapChannelDtoToChannel(channelDto);
            Channel channelToUpdate = service.getChannelById(channelUpdated.getId());
            channelUpdated.setCreated_at(channelToUpdate.getCreated_at());
            return ResponseEntity.ok(mapper.mapChannelToChannelDto(service.updateChannel(channelUpdated)));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
