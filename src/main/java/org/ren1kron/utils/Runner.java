package org.ren1kron.utils;

import org.ren1kron.commands.Command;
import org.ren1kron.exceptions.ExitException;
import org.ren1kron.managers.CommandManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.console.Console;

/**
 * Запускает программу. Запрашивает у пользователя ввод с консоли, парсит его в команды и запускает
 */
public class Runner {
    private final Console console;

    public Runner(Console console) {
        this.console = console;
    }

    public void interactiveMode() {
        try {
            while (console.hasNextLine()) {
                String[] tokens = console.readln().trim().split(" ");

                if (!tokens[0].isEmpty())
                    console.println(runCommand(tokens));
            }
        } catch (ExitException e) {
            console.println("Закрываем программу...");
        }
    }

    private ExecStatus runCommand(String[] tokens) throws ExitException {
        if (tokens[0].equalsIgnoreCase("exit"))
            throw new ExitException();

        Command command = CommandManager.getCommand(tokens[0]);



        Organization organization = null;
        if (command.needOrganization()) {
            try {
                organization = Asker.askOrganization(console);
            } catch (ExitException e) {
                return new ExecStatus(false, "Отменяем операцию...");
            }
        }

        return command.execute(organization, tokens);
    }
}
