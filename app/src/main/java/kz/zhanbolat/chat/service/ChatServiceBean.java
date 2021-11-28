package kz.zhanbolat.chat.service;

import kz.zhanbolat.chat.entity.ChatMessage;
import kz.zhanbolat.chat.repository.ChatRepository;
import kz.zhanbolat.chat.service.validator.ChatMessageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceBean implements ChatService {

    private ChatMessageValidator chatMessageValidator;

    private ChatRepository chatRepository;

    @Autowired
    public ChatServiceBean(ChatMessageValidator chatMessageValidator, ChatRepository chatRepository) {
        this.chatMessageValidator = chatMessageValidator;
        this.chatRepository = chatRepository;
    }

    @Override
    public ChatMessage receiveMessage(ChatMessage message) {
        chatMessageValidator.validateMessage(message);
        return chatRepository.saveMessage(message);
    }
}
