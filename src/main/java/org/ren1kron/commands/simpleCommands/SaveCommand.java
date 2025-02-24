package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.managers.CollectionManager;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

import java.io.IOException;

public class SaveCommand extends Command {
    private final CollectionManager collectionManager = CollectionManager.getInstance();
    public SaveCommand() {
        super("save", "Сохраняет коллекцию в файл", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        if (organization != null || args.length > 1) {
            throw new IllegalArgumentException(String.format("Команде '%s' были переданы невалидные аргументы. Введите 'help' для справки.", getName()));
        }
        try {
            collectionManager.save();
            return new ExecStatus("Коллекция успешно сохранена!");
        } catch (IOException e) {
            return new ExecStatus(false, "Не удалось сохранить коллекцию в файл");
        }
    }
}
