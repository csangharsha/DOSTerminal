package com.sangharsha.dosterminal.commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sangharsha.dosterminal.interfaces.DosCommand;

public class CopyCommand extends DosCommand {

    @Override
    public String execute(String[] params, String path) {

        if (params.length == 3) {
            FileInputStream instream = null;
            FileOutputStream outstream = null;
            String tempPath = path.replace(".", "");
            String srcPath = tempPath + params[1];
            String destPath = tempPath + params[2];
            try {
                File infile = new File(srcPath);
                File outfile = new File(destPath);

                if (!infile.exists()) {
                    System.out.println("File not exists.");
                } else if (outfile.exists()) {
                    System.out.println("Filename already exists.");
                }else if(!outfile.isFile()){
                    System.out.println("Directory found instead of file.");
                }else {

                    instream = new FileInputStream(infile);
                    outstream = new FileOutputStream(outfile);

                    byte[] buffer = new byte[1024];

                    int length;
                    /*copying the contents from input stream to
			    	     * output stream using read and write methods
                     */
                    while ((length = instream.read(buffer)) > 0) {
                        outstream.write(buffer, 0, length);
                    }

                    //Closing the input/output file streams
                    instream.close();
                    outstream.close();

                    System.out.println("File copied successfully!!");
                }

            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } else {
            System.out.println("Invalid number of paramter");
        }

        return path;
    }

}
