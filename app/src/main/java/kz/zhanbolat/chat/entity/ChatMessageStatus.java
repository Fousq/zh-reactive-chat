package kz.zhanbolat.chat.entity;

public enum ChatMessageStatus {
    NEW(0), SEND(1);

    private final int status;

    ChatMessageStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
