package org.ren1kron.commands.simpleCommands;

import org.ren1kron.commands.Command;
import org.ren1kron.module.Organization;
import org.ren1kron.utils.ExecStatus;

public class ExecuteScriptCommand extends Command {

    public ExecuteScriptCommand() {
        super("execute_script", "Считывает и исполняет скрипт из указанного файла.", false);
    }

    @Override
    public ExecStatus execute(Organization organization, String... args) {
        return null;
    }
}
