package org.ren1kron.commands.elementCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class AddCommand extends Command {
    private final static CollectionManager collectionManager = CollectionManager.getInstance();
    public AddCommand() {
        super("add", "Добавляет элемент в коллекцию", true);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization == null || args.length != 1)
            throw new IllegalArgumentException("Команде add были переданы невалидные аргументы");

        if (collectionManager.add(organization))
            return new ExecStatus("Организация успешно добавлена в коллекцию!");
        return new ExecStatus(false, "Не удалось добавить элемент в коллекцию");
    }
}
