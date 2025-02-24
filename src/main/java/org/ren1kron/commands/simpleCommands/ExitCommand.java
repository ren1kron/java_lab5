package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit", "Закрывает программу без сохранения коллекции в файл", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        return null;
    }
}
