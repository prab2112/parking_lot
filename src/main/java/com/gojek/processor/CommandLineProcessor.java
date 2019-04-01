package com.gojek.processor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: ParkingLot
 * Created On : 4/1/19
 */
public class CommandLineProcessor extends AbstractProcessor {

    @Override
    public void process() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            validateAndProcess(str);
        }
    }
}
