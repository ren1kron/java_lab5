package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CommandManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class HelpCommand extends Command {

    public HelpCommand() {
        super("help", "Выводит справку о всех командах", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization != null || args.length > 1) {
            throw new IllegalArgumentException("Для команды help не нужны аргументы");
        }
        StringBuilder sb = new StringBuilder();

        String HEADER_COLOR = "\u001B[34m"; // Синий цвет заголовка
        String RESET        = "\u001B[0m";  // Сброс цвета

        sb.append("┌──────────────────────┬───────────────────────────────────────────────────┐\n");
        sb.append(String.format("│ " + HEADER_COLOR + "%-20s" + RESET + " │ " + HEADER_COLOR + "%-50s" + RESET + "│%n", "Команда", "Описание"));
        sb.append("├──────────────────────┼───────────────────────────────────────────────────┤\n");

        for (Command command : CommandManager.getCommandMap().values()) {
            sb.append(String.format("│ %-20s │ %-50s│%n", command.getName(), command.getDescription()));
        }

        sb.append("└──────────────────────┴───────────────────────────────────────────────────┘\n");



        return new ExecStatus(sb.toString());
    }
}
