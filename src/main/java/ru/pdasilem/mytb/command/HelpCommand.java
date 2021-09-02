package ru.pdasilem.mytb.command;

import org.telegram.telegrambots.meta.api.objects.Update;
import ru.pdasilem.mytb.service.SendBotMessageService;

import static ru.pdasilem.mytb.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("<b>Commands:</b>\n\n"
            + "<b>Start\\Stop</b>\n"
            + "%s - start work\n"
            + "%s - stop bot\n"
            + "%s - help\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
