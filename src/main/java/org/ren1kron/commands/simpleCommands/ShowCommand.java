package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class ShowCommand extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public ShowCommand() {
        super("show", "Выводит в стандартный поток вывода все элементы коллекции в строковом представлении", false);
    }
    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization != null || args.length > 1) {
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));
        }

        StringBuilder sb = new StringBuilder();
        String HEADER_COLOR = "\u001B[34m"; // Синий цвет заголовка
        String RESET = "\u001B[0m";  // Сброс цвета

        sb.append("┌──────────────────────────────────────────────────────────────────┐\n");
        sb.append(String.format("│ " + HEADER_COLOR + "%-64s" + RESET + " │%n", "Collection Contents"));

        for (Organization org : collectionManager.getCollection()) {
            sb.append("├──────────────────────────────────────────────────────────────────┤\n");
            sb.append(String.format("│ ID: %-60d │%n", org.getId()));
            sb.append(String.format("│ Name: %-58s │%n", org.getName()));
            sb.append(String.format("│ Coordinates: X: %-10d; Y: %-33.2f │%n", org.getCoordinates().getX(), org.getCoordinates().getY()));
            sb.append(String.format("│ Creation Date: %-49s │%n", org.getCreationDate().toLocalDate()));
            sb.append(String.format("│ Creation Time: %-49s │%n", org.getCreationDate().toLocalTime()));
            sb.append(String.format("│ Annual Turnover: %-47d │%n", org.getAnnualTurnover()));
            sb.append(String.format("│ Full Name: %-53s │%n", org.getFullName()));
            sb.append(String.format("│ Employees: %-53d │%n", org.getEmployeesCount()));
            sb.append(String.format("│ Type: %-58s │%n", org.getType()));
            sb.append(String.format("│ Postal Address: %-48s │%n", org.getPostalAddress().getZipCode()));
            sb.append(String.format("│ Location: X: %-5d; Y: %-5d; Name: %-28s │%n",
                    org.getPostalAddress().getTown().getX(),
                    org.getPostalAddress().getTown().getY(),
                    org.getPostalAddress().getTown().getName()));
        }

        sb.append("└──────────────────────────────────────────────────────────────────┘\n");

        return new ExecStatus(sb.toString());
    }

}
