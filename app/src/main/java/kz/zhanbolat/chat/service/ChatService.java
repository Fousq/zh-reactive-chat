package kz.zhanbolat.chat.service;

import kz.zhanbolat.chat.entity.ChatMessage;

public interface ChatService {
    ChatMessage receiveMessage(ChatMessage message);
}
