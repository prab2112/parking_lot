package com.gojek.processor;

import com.gojek.constants.Commands;
import com.gojek.models.Car;
import com.gojek.service.ParkingLot;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: ParkingLot
 * Created On : 4/1/19
 */
public abstract class AbstractProcessor {
    ParkingLot parkingLot = null;

    public abstract void process() throws Exception;

    public void validateAndProcess(String line) throws Exception {
        String input[] = line.split(" ");
        String command = input[0];
        if (command.equals("")) {
            System.out.println("Thanks for using the program");
            return;
        }

        if (command == null) {
            System.out.println("Invalid command");
            return;
        }

        switch (command) {
            case Commands.CREATE:
                if (input.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                int noOfSlots = Integer.parseInt(input[1]);
                parkingLot = ParkingLot.createParkingLot(noOfSlots);
                break;
            case Commands.PARK:
                if (input.length != 3) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }

                String regNo = input[1];
                String color = input[2];
                parkingLot.parkCar(new Car(regNo, color));
                break;
            case Commands.LEAVE:
                if (input.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                int slotNo = Integer.parseInt(input[1]);
                parkingLot.leaveSlot(slotNo);
                break;
            case Commands.STATUS:
                if (input.length != 1) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                parkingLot.getStatus();
                break;
            case Commands.FETCH_SLOT_FROM_REG_NO:
                if (input.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                parkingLot.getSlotNumberFromRegNo(input[1]);
                break;
            case Commands.FETCH_CARE_FROM_COLOR:
                if (input.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }

                parkingLot.getRegistrationNumbersFromColor(input[1]);
                break;
            case Commands.FETCH_SLOT_FROM_COLOR:
                if (input.length != 2) {
                    throw new Exception("Invalid no of arguments for command : " + command);
                }
                parkingLot.getSlotNumbersFromColor(input[1]);
                break;
            case Commands.EXIT:
                System.exit(0);


        }

    }

}
