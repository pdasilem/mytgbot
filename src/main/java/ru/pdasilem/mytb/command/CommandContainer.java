package ru.pdasilem.mytb.command;

import com.google.common.collect.ImmutableMap;
import ru.pdasilem.mytb.service.SendBotMessageService;

import static ru.pdasilem.mytb.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandsMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {
        commandsMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();
        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandsMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
