package ru.pdasilem.mytb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.pdasilem.mytb.bot.JavarushTelegramBot;
import ru.pdasilem.mytb.service.SendBotMessageService;
import ru.pdasilem.mytb.service.SendBotMessageServiceImpl;

@DisplayName("Unit test for SendMessageBotService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private JavarushTelegramBot javarushTgBot;

    @BeforeEach
    public void init() {
        javarushTgBot = Mockito.mock(JavarushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushTgBot);
    }

    @Test
    public void shouldSendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message_fine";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(javarushTgBot).execute(sendMessage);
    }
}
