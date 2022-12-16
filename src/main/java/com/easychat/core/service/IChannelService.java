package com.easychat.core.service;

import com.easychat.core.entity.Channel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IChannelService {

    List<Channel> getAllChannels();
    Channel getChannelById(Integer id) throws Exception;
    Channel createChannel(Channel channel);
    Channel updateChannel(Channel channel) throws Exception;
    void deleteChannel(Channel channel) throws Exception;
}
