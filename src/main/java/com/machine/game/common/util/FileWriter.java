package com.machine.game.common.util;

import org.springframework.stereotype.Component;

import java.io.*;


@Component
public class FileWriter {

    static FileOutputStream fos;
    static File file = new File(System.getProperty("user.dir").concat("/src").concat("/main").concat("/resources").concat("/gridPrint.txt"));

    public static void write(String content) {
        try {


            if(!file.exists()){
                file.createNewFile();

            }

            fos = new FileOutputStream(file,true);
            fos.write(content.getBytes());
            fos.flush();

            //System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
