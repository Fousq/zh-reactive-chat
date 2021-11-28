package kz.zhanbolat.chat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kz.zhanbolat.chat.entity.ChatMessage;
import kz.zhanbolat.chat.entity.ChatMessageStatus;
import kz.zhanbolat.chat.service.ChatService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatReceiveMessageDefinition {
    private static ApplicationContext applicationContext;

    private ChatMessage message;
    private ChatService chatService;
    private ChatMessage processedMessage;

    public ChatReceiveMessageDefinition() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        chatService = context.getBean(ChatService.class);
    }

    @Given("new not empty message")
    public void newNotEmptyMessage() {
        message = new ChatMessage();
        message.setStatus(ChatMessageStatus.NEW);
        message.setText("test");
        message.setUserId(1L);
    }

    @When("receive message")
    public void receiveMessage() {
        processedMessage = chatService.receiveMessage(message);
    }

    @Then("return message with status 'Send'")
    public void returnMessageWithStatusSend() {
        assertEquals(ChatMessageStatus.SEND, processedMessage.getStatus());
        assertEquals(message.getText(), processedMessage.getText());
        assertEquals(message.getUserId(), processedMessage.getUserId());
    }
}
