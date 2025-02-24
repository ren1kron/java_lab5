package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CommandManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class HistoryCommand extends Command {

    public HistoryCommand() {
        super("history", "Выводит последние 11 команд", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization != null || args.length > 1) {
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));
        }

        StringBuilder sb = new StringBuilder();

        String HEADER_COLOR = "\u001B[34m"; // Синий цвет заголовка
        String RESET        = "\u001B[0m";  // Сброс цвета
        sb.append("┌─────────────────────────────────────────────┐\n");
        sb.append(String.format("│ " + HEADER_COLOR + "%-43s" + RESET + " │%n", "История"));

        int i = 1;
        for (Command command : CommandManager.getHistory()) {
            sb.append("├─────────────────────────────────────────────┤\n");
            sb.append(String.format("│ %-2d) %-39s │%n", i++, command.getName()));
        }

        sb.append("└─────────────────────────────────────────────┘\n");

        return new ExecStatus(sb.toString());
    }
}
