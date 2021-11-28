package kz.zhanbolat.chat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import kz.zhanbolat.chat.entity.ChatMessage;
import kz.zhanbolat.chat.service.ChatService;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChatReceiveMessageDefinition {
    private ChatMessage message;
    private ChatService chatService;
    private ChatMessage processedMessage;

    @Given("new not empty message")
    public void newNotEmptyMessage() {
        message = new ChatMessage();
        message.setStatus(0);
        message.setText("test");
        message.setUserId(1L);
    }

    @When("receive message")
    public void receiveMessage() {
        processedMessage = chatService.receiveMessage(message);
    }

    @Then("return message with status 'Send'")
    public void returnMessageWithStatusSend() {
        assertEquals(1, processedMessage.getStatus());
        assertEquals(message.getText(), processedMessage.getText());
        assertEquals(message.getUserId(), processedMessage.getUserId());
    }
}
