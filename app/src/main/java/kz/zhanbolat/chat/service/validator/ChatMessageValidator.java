package kz.zhanbolat.chat.service.validator;

import kz.zhanbolat.chat.entity.ChatMessage;

public interface ChatMessageValidator {
    void validateMessage(ChatMessage chatMessage);
}
