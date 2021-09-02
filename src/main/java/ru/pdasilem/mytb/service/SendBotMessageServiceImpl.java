package ru.pdasilem.mytb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.pdasilem.mytb.bot.JavarushTelegramBot;

@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private final JavarushTelegramBot jrtbBot;

    @Autowired
    public SendBotMessageServiceImpl(JavarushTelegramBot jrtbBot) {
        this.jrtbBot = jrtbBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            jrtbBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
