package ru.pdasilem.mytb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pdasilem.mytb.service.SendBotMessageService;

public class NoCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String NO_MESSAGE = "Unsupported command, should begin with slash (/). \n"
            + "Type /help to see available commands";

    public NoCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
