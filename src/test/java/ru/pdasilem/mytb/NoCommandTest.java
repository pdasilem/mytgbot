package ru.pdasilem.mytb;

import ru.pdasilem.mytb.command.Command;
import ru.pdasilem.mytb.command.NoCommand;

import static ru.pdasilem.mytb.command.CommandName.NO;
import static ru.pdasilem.mytb.command.NoCommand.NO_MESSAGE;

public class NoCommandTest extends AbstractCommandTest{

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }
}
