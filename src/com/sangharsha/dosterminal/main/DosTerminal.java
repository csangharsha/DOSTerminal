package com.sangharsha.dosterminal.main;

import com.sangharsha.dosterminal.interfaces.DosCommand;
import com.sangharsha.dosterminal.interfaces.DosCommandFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sangharsha
 */
public class DosTerminal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            File pwd = new File(".");
            String path = pwd.getAbsolutePath();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String line = "";
                System.out.print(path + ">");
                while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                    
                    String tokens[] = line.split(" ");
                    DosCommand cmd = DosCommandFactory.get(tokens[0]);
                    if (cmd != null) {
                        path = cmd.execute(tokens, path);
                    } else {
                        System.out.println("" + tokens[0] + " is not recognized as internal or external command");
                    }
                    
                    System.out.print(path + ">");
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
