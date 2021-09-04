package ru.pdasilem.mytb;

import ru.pdasilem.mytb.command.Command;
import ru.pdasilem.mytb.command.StopCommand;

import static ru.pdasilem.mytb.command.CommandName.STOP;
import static ru.pdasilem.mytb.command.StopCommand.STOP_MESSAGE;

public class StopCommandTest extends AbstractCommandTest {


    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService, telegramUserService);
    }
}
