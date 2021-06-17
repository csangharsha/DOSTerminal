package com.sangharsha.dosterminal.commands;

import java.io.File;
import java.io.FilenameFilter;

import com.sangharsha.dosterminal.interfaces.DosCommand;

public class DirCommand extends DosCommand {

    @Override
    public String execute(String[] params, String path) {
        if (params.length <= 3) {
            if (params.length == 1) {
                File f = new File(path);
                if (f.exists() && f.isDirectory()) {
                    getList(path);
                } else {
                    System.out.println("File Not Found");
                }
            } else {
                if (params[1].startsWith("-")) { // check if 2nd parameter is
                    // argument
                    File f = new File(path);
                    if (f.exists() && f.isDirectory()) {
                        if (params[1].equals("-a")) {
                            getList(path);
                        } else if (params[1].equals("-d")) {
                            getDirectoryList(path);
                        } else if (params[1].equals("-f")) {
                            getFileList(path);
                        } else {
                            System.out.println("Invalid Switch " + params[1]);
                            System.out.println();
                            System.out.println("Did you mean:");
                            System.out.println("-a : to gell all files and directories");
                            System.out.println("-d : to gell all directories");
                            System.out.println("-f : to gell all files");
                        }
                    } else {
                        System.out.println("File Not Found");
                    }
                } else {
                    if (params.length == 3) {
                        if (params[2].startsWith("-")) { // check if 3nd
                            // parameter is
                            // argument then 2nd
                            // argument is
                            // subfolder of
                            // current folder
                            String temp_path = "";
                            temp_path = path.replace(".", "");
                            if (params[1].startsWith(System.getProperty("file.separator"))) {
                                params[1] = params[1].substring(1, params[1].length() - 1);
                            }
                            temp_path = temp_path + params[1];
                            temp_path = temp_path + System.getProperty("file.separator") + ".";
                            File f = new File(temp_path);
                            if (f.exists() && f.isDirectory()) {
                                if (params[2].equals("-a")) {
                                    getList(temp_path);
                                } else if (params[2].equals("-d")) {
                                    getDirectoryList(temp_path);
                                } else if (params[2].equals("-f")) {
                                    getFileList(temp_path);
                                } else {
                                    System.out.println("Did you mean:");
                                    System.out.println("-a : to gell all files and directories");
                                    System.out.println("-d : to gell all directories");
                                    System.out.println("-f : to gell all files");
                                }
                            } else {
                                System.out.println("File Not Found");
                            }
                        } else {
                            System.out.println("File Not Found.");
                        }
                    } else {
                        String temp_path = "";
                        temp_path = path.replace(".", "");
                        if (params[1].startsWith(System.getProperty("file.separator"))) {
                            params[1] = params[1].substring(1, params[1].length() - 1);
                        }
                        temp_path = temp_path + params[1];
                        temp_path = temp_path + System.getProperty("file.separator") + ".";
                        File f = new File(temp_path);
                        if (f.exists() && f.isDirectory()) {
                            getList(temp_path);
                        } else {
                            System.out.println("File Not Found");
                        }
                    }
                }
            }
        } else {
            System.out.println("File Not Found.");
        }
        return path;
    }

    private void getList(String path) {
        File f = null;
        String[] paths;
        try {
            // create new file
            f = new File(path);

            // array of files and directory
            paths = f.list();

            // for each name in the path array
            for (String path1 : paths) {
                // prints filename and directory name
                System.out.println(path1);
            }
        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
            System.out.println("Some thing is wrong");
        }
    }

    private void getDirectoryList(String path) {
        File file = new File(path);
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        for (String path1 : directories) {
            // prints filename and directory name
            System.out.println(path1);
        }
    }

    private void getFileList(String path) {
        File file = new File(path);
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return !(new File(current, name).isDirectory());
            }
        });
        for (String path1 : directories) {
            // prints filename and directory name
            System.out.println(path1);
        }
    }
}
