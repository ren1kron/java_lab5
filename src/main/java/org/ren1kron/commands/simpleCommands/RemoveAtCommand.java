package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class RemoveAtCommand extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public RemoveAtCommand() {
        super("remove_at index", "Удаляет элемент из коллекции по его индексу (позиции в коллекции)", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization == null || args.length != 2)
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));

        int index = Integer.parseInt(args[1]);
        try {
            collectionManager.removeByIndex(index);
            return new ExecStatus("Элемент был успешно удалён");
        } catch (IndexOutOfBoundsException e) {
            return new ExecStatus(false, "Индекс вышел за пределы коллекции");
        }
    }
}
