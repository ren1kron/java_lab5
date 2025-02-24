package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class PrintFieldAscendingEmployeesCountCommand extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public PrintFieldAscendingEmployeesCountCommand() {
        super("print_field_ascending_employees_count", "Выводит значения поля employeesCount всех элементов в порядке возрастания", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization != null || args.length != 1) {
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));
        }

        StringBuilder sb = new StringBuilder();

        String HEADER_COLOR = "\u001B[34m"; // Синий цвет заголовка
        String RESET        = "\u001B[0m";  // Сброс цвета
        sb.append("┌─────────────────────────────────────────────┐\n");
        sb.append(String.format("│ " + HEADER_COLOR + "%-43s" + RESET + " │%n", "Количество работников каждой Организации в порядке возрастания"));

        int i = 1;
        for (Organization org : collectionManager) {
            sb.append("├─────────────────────────────────────────────┤\n");
            sb.append(String.format("│ %d) %-40d │%n", i++, org.getEmployeesCount()));
        }

        sb.append("└─────────────────────────────────────────────┘\n");

        return new ExecStatus(sb.toString());
    }
}
