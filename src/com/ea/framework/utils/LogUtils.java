package com.ea.framework.utils;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtils {
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format(formatter);
    private BufferedWriter bufferedWriter = null;

    public void createFile() {
        try {
            File dir = new File("E:/logs/");
            if (!dir.exists()) {
                dir.mkdir();
            }
                //create file
                File logFile = new File(dir + "/" + fileNameFormat+".log");
                FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
                bufferedWriter = new BufferedWriter(fileWriter);

        }
        catch (Exception e) {

        }
    }


    public void Write(String message) throws IOException {
        try {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH_MM_SS");
            String fileNameFormat = date.format(formatter);
            bufferedWriter.write("["+fileNameFormat+"]"+message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {

        }
    }
}
