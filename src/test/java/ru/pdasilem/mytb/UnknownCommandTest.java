package ru.pdasilem.mytb;

import ru.pdasilem.mytb.command.Command;
import ru.pdasilem.mytb.command.UnknownCommand;

import static ru.pdasilem.mytb.command.UnknownCommand.UNKNOWN_MESSAGE;

public class UnknownCommandTest extends AbstractCommandTest {


    @Override
    String getCommandName() {
        return "/null_null";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
