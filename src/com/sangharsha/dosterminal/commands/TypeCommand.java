package com.sangharsha.dosterminal.commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.sangharsha.dosterminal.interfaces.DosCommand;

public class TypeCommand extends DosCommand {

    @Override
    public String execute(String[] params, String path) {
        String tempPath = path.replace(".", "");
        tempPath = tempPath + params[1];
        File file = new File(tempPath);
        try {
            if (file.exists() && !file.isDirectory()) {
                BufferedReader br = new BufferedReader(new FileReader(tempPath));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
            } else {
                System.out.println("File not exist");
            }
        } catch (Exception e) {
            System.out.println("Something is wrong.");
        }
        return path;
    }
}
