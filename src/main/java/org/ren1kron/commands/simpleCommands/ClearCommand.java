package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class ClearCommand extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public ClearCommand() {
        super("clear", "Очищает коллекцию", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization != null || args.length > 1) {
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));
        }

        collectionManager.clear();
        return new ExecStatus("Коллекция была успешно очищена");
    }
}
