package com.gojek.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: ParkingLot
 * Created On : 4/1/19
 */
public class FileProcessor extends AbstractProcessor {
    String path = null;

    public FileProcessor(String path) {
        this.path = path;
    }

    @Override
    public void process() throws Exception {
        File filePath = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            validateAndProcess(line);
        }


    }
}
