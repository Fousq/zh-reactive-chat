package kz.zhanbolat.chat.repository;

import kz.zhanbolat.chat.entity.ChatMessage;
import kz.zhanbolat.chat.entity.ChatMessageStatus;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Repository works with in memory map to emulate the work of databases
 */
@Repository
public class InMemoryChatRepositoryBean implements ChatRepository {

    private static final AtomicLong counter = new AtomicLong();
    private static final ConcurrentHashMap<Long, Object> database = new ConcurrentHashMap<>();

    @Override
    public ChatMessage saveMessage(ChatMessage message) {
        long id = counter.getAndIncrement();
        database.put(id, message);
        message.setId(id);
        message.setStatus(ChatMessageStatus.SEND);

        return message;
    }
}
