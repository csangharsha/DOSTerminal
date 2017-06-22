package com.sangharsha.dosterminal.commands;

import com.sangharsha.dosterminal.interfaces.DosCommand;

public class ClearCommand extends DosCommand {

    @Override
    public String execute(String[] params, String path) {
        return path;
    }

}
