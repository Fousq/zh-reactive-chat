package kz.zhanbolat.chat.repository;

import kz.zhanbolat.chat.entity.ChatMessage;

public interface ChatRepository {
    ChatMessage saveMessage(ChatMessage message);
}
