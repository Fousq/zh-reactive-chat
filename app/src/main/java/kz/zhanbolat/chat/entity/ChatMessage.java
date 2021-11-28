package kz.zhanbolat.chat.entity;

public class ChatMessage {
    private Long id;
    private String text;
    private ChatMessageStatus status;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ChatMessageStatus getStatus() {
        return status;
    }

    public void setStatus(ChatMessageStatus status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
