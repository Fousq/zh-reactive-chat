package kz.zhanbolat.chat.service.validator;

import com.google.common.base.Strings;
import kz.zhanbolat.chat.entity.ChatMessage;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ChatMessageValidatorBean implements ChatMessageValidator {

    @Override
    public void validateMessage(ChatMessage chatMessage) {
        if (Strings.isNullOrEmpty(chatMessage.getText())) {
            throw new IllegalArgumentException("The message text must not be empty");
        }
        if (Objects.isNull(chatMessage.getUserId())) {
            throw new IllegalArgumentException("The message user must not be absent");
        }
        if (Objects.isNull(chatMessage.getStatus())) {
            throw new IllegalArgumentException("The message status must not be absent");
        }
    }
}
