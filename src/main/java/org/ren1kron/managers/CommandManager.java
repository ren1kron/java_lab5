package org.ren1kron.managers;

import lombok.Getter;
import org.ren1kron.commands.Command;
import org.ren1kron.commands.elementCommands.AddCommand;
import org.ren1kron.commands.simpleCommands.ExitCommand;
import org.ren1kron.commands.simpleCommands.HelpCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private static CommandManager instance;
    private CommandManager(){}

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
        }
        return instance;
    }


    @Getter
    private static final Map<String, Command> commandMap = new HashMap<>();

    static {
        commandMap.put("help", new HelpCommand());
        commandMap.put("exit", new ExitCommand());
        commandMap.put("add", new AddCommand());
    }

    public static Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }

}
