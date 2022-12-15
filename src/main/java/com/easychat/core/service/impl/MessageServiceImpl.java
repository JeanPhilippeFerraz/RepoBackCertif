package com.easychat.core.service.impl;

import com.easychat.core.entity.Message;
import com.easychat.core.repository.MessageRepository;
import com.easychat.core.service.IMessageService;

import java.util.List;

public class MessageServiceImpl implements IMessageService {

    MessageRepository repository;

    @Override
    public Message createMessage(Message message) {
        return repository.save(message);
    }

    @Override
    public List<Message> getAllMessage() {
        return repository.findAll();
    }

    @Override
    public Message getMessageById(Integer id) throws Exception {
        return repository.findById(id).orElseThrow(Exception::new);
    }

    @Override
    public Message updateMessage(Message message) throws Exception {

        Message messageToUpdate = repository.findById(message.getId()).orElseThrow(Exception::new);

        messageToUpdate.setText(message.getText());
        messageToUpdate.setChannel(message.getChannel());
        messageToUpdate.setUpdated_at(message.getUpdated_at());
    }

    @Override
    public void deleteMessage(Message message) throws Exception {
        Message messageToDelete = repository.findById(message.getId()).orElseThrow(Exception::new);
        repository.delete(messageToDelete);
    }
}
