package com.sangharsha.dosterminal.commands;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.sangharsha.dosterminal.interfaces.DosCommand;

public class DownloadCommand extends DosCommand {

    @Override
    public String execute(String[] params, String path) {
        if (params.length == 1) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Enter URL to enter: ");
                String line = reader.readLine();
                downloadFile(line);
                System.out.println("Download Completed!!!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else if (params.length == 2) {
            try {
                downloadFile(params[1]);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Download Completed !!!");
        } else if (params.length == 3) {
            if (params[1].equals("-f")) {
                int count = 0;
                try {
                    FileInputStream fstream = new FileInputStream(params[2]);
                    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                    String strLine;
                    //Read File Line By Line
                    while ((strLine = br.readLine()) != null) {
                        downloadFile(strLine);
                        count++;
                    }

                    //Close the input stream
                    br.close();
                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

                System.out.println(count + " File(s) Downloaded!!!");
            } else {
                System.out.println("Did you mean: download -f filename");
            }
        }
        return path;
    }

    private void downloadFile(String urlStr) throws MalformedURLException, IOException, FileNotFoundException {
        URL url = new URL(urlStr);
        URLConnection conn = url.openConnection();
        conn.addRequestProperty("User-Agent",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        byte[] data = new byte[1024];
        InputStream is = conn.getInputStream();
        String[] tokens = urlStr.split("/");
        FileOutputStream os = new FileOutputStream(tokens[tokens.length - 1]);
        int i = 0;
        System.out.print("...");
        while ((i = is.read(data)) != -1) {
            System.out.print(".");
            os.write(data, 0, i);
        }
        System.out.println("");
        is.close();
        os.close();
    }
}
