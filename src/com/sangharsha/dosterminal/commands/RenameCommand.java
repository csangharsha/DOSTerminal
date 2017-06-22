package com.sangharsha.dosterminal.commands;

import java.io.File;

import com.sangharsha.dosterminal.interfaces.DosCommand;

public class RenameCommand extends DosCommand {

    @Override
    public String execute(String[] params, String path) {
        // File (or directory) with old name
        String tempPath = path.replace(".", "");
        String srcPath = tempPath + params[1];
        String destPath = tempPath + params[2];

        File file1 = new File(srcPath);
        File file2 = new File(destPath);

        if (file2.exists()) {
            System.out.println("Filename already exists.");
            return path;
        }

        // Rename file (or directory)
        boolean success = file1.renameTo(file2);

        if (!success) {
            System.out.println("File cannot be renamed.");
        }
        return path;
    }

}
