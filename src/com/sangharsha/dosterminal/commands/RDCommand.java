package com.sangharsha.dosterminal.commands;

import java.io.File;

import com.sangharsha.dosterminal.interfaces.DosCommand;

public class RDCommand extends DosCommand {

    @Override
    public String execute(String[] params, String path) {
        if (params.length > 1 && params.length < 3) {
            String tempPath = path.replace(".", "");
            File file = new File(tempPath + params[1]);
            System.out.println(file.getAbsolutePath());
            file.delete();
        } else {
            System.out.println("The syntax of the command is incorrect");
        }
        return path;
    }
}
