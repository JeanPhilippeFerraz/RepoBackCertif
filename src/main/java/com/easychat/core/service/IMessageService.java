package com.easychat.core.service;

import com.easychat.core.entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMessageService {

    public Message createMessage(Message message);

    public List<Message> getAllMessage();

    public Message getMessageById(Integer id) throws Exception;

    public Message updateMessage(Message message) throws Exception;

    public void deleteMessage(Message message) throws Exception;

}
