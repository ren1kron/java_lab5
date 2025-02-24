package org.ren1kron.commands.elementCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class UpdateCommand extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public UpdateCommand() {
        super("update id {element}", "Обновляет элемент коллекции, id которого равен заданному", true);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization == null || args.length != 2)
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));

        if (collectionManager.update(Long.parseLong(args[1]), organization))
            return new ExecStatus("Организация успешно обновлена!");
        return new ExecStatus(false, "Не удалось обновить коллекцию. Похоже, элемента с таким ID не существует");
    }
}
