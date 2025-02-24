package org.ren1kron.commands.elementCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class RemoveGreater extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public RemoveGreater() {
        super("remove_greater {element}", "Удаляет из коллекции все элементы, превышающие заданный", true);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization == null || args.length != 1)
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));


    }
}
