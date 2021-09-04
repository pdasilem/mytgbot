package ru.pdasilem.mytb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.pdasilem.mytb.command.Command;
import ru.pdasilem.mytb.command.CommandContainer;
import ru.pdasilem.mytb.command.CommandName;
import ru.pdasilem.mytb.command.UnknownCommand;
import ru.pdasilem.mytb.service.SendBotMessageService;
import ru.pdasilem.mytb.service.TelegramUserService;

import java.util.Arrays;

@DisplayName("Unit test for CommandContainer")
public class CommandContainerTest {

    private CommandContainer commandContainer;

    @BeforeEach
    public void init(){
        SendBotMessageService sendBotMessageService = Mockito.mock(SendBotMessageService.class);
        TelegramUserService telegramUserService = Mockito.mock(TelegramUserService.class);
        commandContainer = new CommandContainer(sendBotMessageService, telegramUserService);
    }

    @Test
    public void shouldGetAllOfExistingCommands() {
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(UnknownCommand.class, command.getClass());
                });
    }

    @Test
    public void ShouldReturnUnknownCommand() {
        String unknownCommand = "/null_null";

        Command command = commandContainer.retrieveCommand(unknownCommand);

        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
