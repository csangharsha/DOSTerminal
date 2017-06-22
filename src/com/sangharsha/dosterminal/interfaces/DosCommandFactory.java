package com.sangharsha.dosterminal.interfaces;

import com.sangharsha.dosterminal.commands.CDCommand;
import com.sangharsha.dosterminal.commands.ClearCommand;
import com.sangharsha.dosterminal.commands.CopyCommand;
import com.sangharsha.dosterminal.commands.DirCommand;
import com.sangharsha.dosterminal.commands.DownloadCommand;
import com.sangharsha.dosterminal.commands.MDCommand;
import com.sangharsha.dosterminal.commands.RDCommand;
import com.sangharsha.dosterminal.commands.RenameCommand;
import com.sangharsha.dosterminal.commands.TypeCommand;

public class DosCommandFactory {

    public static DosCommand get(String key) {
        if (key.equalsIgnoreCase("md")) {
            return new MDCommand();
        } else if (key.equalsIgnoreCase("cd")) {
            return new CDCommand();
        } else if (key.equalsIgnoreCase("rd")) {
            return new RDCommand();
        } else if (key.equalsIgnoreCase("copy")) {
            return new CopyCommand();
        } else if (key.equalsIgnoreCase("rename")) {
            return new RenameCommand();
        } else if (key.equalsIgnoreCase("type")) {
            return new TypeCommand();
        } else if (key.equalsIgnoreCase("dir")) {
            return new DirCommand();
        } else if (key.equalsIgnoreCase("download")) {
            return new DownloadCommand();
        } else if (key.equalsIgnoreCase("clear")) {
            return new ClearCommand();
        } else {
            return null;
        }
    }
}
