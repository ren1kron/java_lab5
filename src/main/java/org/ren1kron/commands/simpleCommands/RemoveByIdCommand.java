package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class RemoveByIdCommand extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public RemoveByIdCommand() {
        super("remove_by_id id", "Удаляет элемент из коллекции по его id", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization == null || args.length != 2)
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));

        if (collectionManager.removeById(Long.parseLong(args[1])))
            return new ExecStatus("Элемент был успешно удалён");
        return new ExecStatus(false, "Не удалось удалить элемент");
    }
}
