package com.gojek.app;

import com.gojek.processor.AbstractProcessor;
import com.gojek.processor.CommandLineProcessor;
import com.gojek.processor.FileProcessor;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: ParkingLot
 * Created On : 4/1/19
 */
public class App {
    public static void main(String[] args) throws Exception {
        AbstractProcessor processor = null;
        if (args.length >= 1) {
            processor = new FileProcessor(args[0]);

        } else {
            processor = new CommandLineProcessor();
        }

        processor.process();
    }
}
