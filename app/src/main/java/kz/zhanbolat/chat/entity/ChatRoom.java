package kz.zhanbolat.chat.entity;

import java.util.List;

public class ChatRoom {
    private Long id;
    private List<ChatUser> chatUserList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ChatUser> getChatUserList() {
        return chatUserList;
    }

    public void setChatUserList(List<ChatUser> chatUserList) {
        this.chatUserList = chatUserList;
    }
}
