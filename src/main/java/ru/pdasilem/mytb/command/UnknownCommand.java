package ru.pdasilem.mytb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pdasilem.mytb.service.SendBotMessageService;

public class UnknownCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String UNKNOWN_MESSAGE = "I don't understand you \uD83D\uDE1F. Type /help";

    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
