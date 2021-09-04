package ru.pdasilem.mytb;

import ru.pdasilem.mytb.command.Command;
import ru.pdasilem.mytb.command.StatCommand;

import static ru.pdasilem.mytb.command.CommandName.STAT;
import static ru.pdasilem.mytb.command.StatCommand.STAT_MESSAGE;

public class StatCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return STAT.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return String.format(STAT_MESSAGE, 0);
    }

    @Override
    Command getCommand() {
        return new StatCommand(telegramUserService, sendBotMessageService);
    }
}
