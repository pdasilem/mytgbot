package ru.pdasilem.mytb;

import ru.pdasilem.mytb.command.Command;
import ru.pdasilem.mytb.command.StartCommand;

import static ru.pdasilem.mytb.command.CommandName.START;
import static ru.pdasilem.mytb.command.StartCommand.START_MESSAGE;

public class StartCommandTest extends AbstractCommandTest {


    @Override
    String getCommandName() {
        return START.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService);
    }
}
