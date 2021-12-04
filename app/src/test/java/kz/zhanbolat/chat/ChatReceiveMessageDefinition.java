package kz.zhanbolat.chat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kz.zhanbolat.chat.entity.ChatMessage;
import kz.zhanbolat.chat.entity.ChatMessageStatus;
import kz.zhanbolat.chat.service.ChatService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChatReceiveMessageDefinition {
    private static final String TEST_VALUE = "test";
    private static final Long USER_ID = 1L;

    private static ApplicationContext applicationContext;

    private ChatMessage message;
    private ChatService chatService;
    private ChatMessage processedMessage;
    private Exception exception;

    public ChatReceiveMessageDefinition() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        chatService = context.getBean(ChatService.class);
    }

    // Scenario: The new not empty message was received
    @Given("new not empty message")
    public void newNotEmptyMessage() {
        message = new ChatMessage();
        message.setStatus(ChatMessageStatus.NEW);
        message.setText(TEST_VALUE);
        message.setUserId(USER_ID);
    }

    @When("receive not empty message")
    public void receiveMessage() {
        processedMessage = chatService.receiveMessage(message);
    }

    @Then("return message with status 'Send'")
    public void returnMessageWithStatusSend() {
        assertEquals(ChatMessageStatus.SEND, processedMessage.getStatus());
        assertEquals(message.getText(), processedMessage.getText());
        assertEquals(message.getUserId(), processedMessage.getUserId());
    }

    // Scenario: Empty text message was received
    @Given("empty text message")
    public void emptyTextMessage() {
        message = new ChatMessage();
        message.setStatus(ChatMessageStatus.NEW);
        message.setUserId(USER_ID);
        message.setText("");
    }

    @When("receive empty text message")
    public void receiveEmptyTextMessage() {
        exception = assertThrows(IllegalArgumentException.class, () -> chatService.receiveMessage(message));
    }

    @Then("return empty text error")
    public void throwException() {
        assertEquals("The message text must not be empty", exception.getMessage());
    }

    // Scenario: Receive message without user
    @Given("message without user")
    public void messageWithoutUser() {
        message = new ChatMessage();
        message.setStatus(ChatMessageStatus.NEW);
        message.setText(TEST_VALUE);
        message.setUserId(null);
    }

    @When("receive message without user")
    public void receiveMessageWithoutUser() {
        exception = assertThrows(IllegalArgumentException.class, () -> chatService.receiveMessage(message));
    }

    @Then("return user absent error")
    public void returnUserAbsentError() {
        assertEquals("The message user must not be absent", exception.getMessage());
    }

    // Scenario: Receive message without status
    @Given("message without status")
    public void messageWithoutStatus() {
        message = new ChatMessage();
        message.setText(TEST_VALUE);
        message.setStatus(null);
        message.setUserId(USER_ID);
    }

    @When("receive message without status")
    public void receiveMessageWithoutStatus() {
        exception = assertThrows(IllegalArgumentException.class, () -> chatService.receiveMessage(message));
    }

    @Then("return status absent error")
    public void returnStatusAbsentError() {
        assertEquals("The message status must not be absent", exception.getMessage());
    }
}
