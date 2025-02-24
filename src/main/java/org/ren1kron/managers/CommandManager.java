package org.ren1kron.managers;

import lombok.Getter;
import org.ren1kron.commands.*;
import org.ren1kron.commands.elementCommands.*;
import org.ren1kron.commands.simpleCommands.*;

import java.util.*;

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
    private static final Map<String, Command> commandMap = new LinkedHashMap<>();
    @Getter
    private static final Deque<Command> history = new LinkedList<>();

    static {
        commandMap.put("help", new HelpCommand());
        commandMap.put("info", new InfoCommand());
        commandMap.put("show", new ShowCommand());
        commandMap.put("add", new AddCommand());
        commandMap.put("update", new UpdateCommand());
        commandMap.put("remove_by_id", new RemoveByIdCommand());
        commandMap.put("clear", new ClearCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("execute_script", new ExecuteScriptCommand());
        commandMap.put("exit", new ExitCommand());
        commandMap.put("remove_at", new RemoveAtCommand());
        commandMap.put("remove_greater", new RemoveGreaterCommand());
        commandMap.put("history", new HistoryCommand());
        commandMap.put("sum_of_employees_count", new SumOfEmployeesCountCommand());
        commandMap.put("filter_starts_with_full_name", new FilterStartsWithFullNameCommand());
        commandMap.put("print_field_ascending_employees_count", new PrintFieldAscendingEmployeesCountCommand());
    }

    public Command getCommand(String commandName) {
        return commandMap.get(commandName);
    }
    public void updateHistory(Command command) {
        history.addLast(command);
        if (history.size() > 11)
            history.removeFirst();
    }

}
