package ru.pdasilem.mytb;

import org.junit.jupiter.api.DisplayName;
import ru.pdasilem.mytb.command.Command;
import ru.pdasilem.mytb.command.HelpCommand;

import static ru.pdasilem.mytb.command.CommandName.HELP;
import static ru.pdasilem.mytb.command.HelpCommand.HELP_MESSAGE;

@DisplayName("Unit test for HelpCommand")
public class HelpCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }
}
