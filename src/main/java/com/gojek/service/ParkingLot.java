package com.gojek.service;

import com.gojek.models.Car;

import java.util.*;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: ParkingLot
 * Created On : 4/1/19
 */
public class ParkingLot {

    private int noOfParkingSlots = 0;
    private List<Integer> availableCarSlots;
    private Map<Integer, Car> slotCarMap;
    private Map<String, Integer> regNoSlotCarMap;
    private Map<String, List<String>> colorCarMap;
    private static ParkingLot parkingLotProcessor = null;

    private ParkingLot(int noOfParkingSlots) {
        this.noOfParkingSlots = noOfParkingSlots;
        availableCarSlots = new ArrayList<>();

        for (int i = 1; i <= noOfParkingSlots; i++) {
            availableCarSlots.add(i);
        }
        slotCarMap = new HashMap<>();
        regNoSlotCarMap = new HashMap<>();
        colorCarMap = new HashMap<>();

        System.out.println("Created parking lot with " + noOfParkingSlots + " slots");
        System.out.println();
    }

    public static ParkingLot createParkingLot(int noOfParkingSlots) {
        if (parkingLotProcessor != null) {
            return parkingLotProcessor;
        } else {
            parkingLotProcessor = new ParkingLot(noOfParkingSlots);
            return parkingLotProcessor;
        }

    }

    public void parkCar(Car car) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created\n");
            return;
        } else if (slotCarMap.size() == noOfParkingSlots) {
            System.out.println("Sorry, parking lot is full\n");
            return;
        } else {
            Collections.sort(availableCarSlots);
            int slot = availableCarSlots.get(0);
            slotCarMap.put(slot, car);
            regNoSlotCarMap.put(car.getRegNo(), slot);
            if (colorCarMap.containsKey(car.getColor())) {
                List<String> regNoList = colorCarMap.get(car.getColor());
                colorCarMap.remove(car.getColor());
                regNoList.add(car.getRegNo());
                colorCarMap.put(car.getColor(), regNoList);
            } else {
                // LinkedList because frequent updation is required
                LinkedList<String> regNoList =
                        new LinkedList<>();
                regNoList.add(car.getRegNo());
                colorCarMap.put(car.getColor(), regNoList);
            }
            System.out.println("Allocated slot number: " + slot + "\n");
            availableCarSlots.remove(0);
        }
    }

    public void leaveSlot(Integer slotNo) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created\\n");
        } else if (slotCarMap.size() > 0) {
            Car carToLeave = slotCarMap.get(slotNo);
            if (carToLeave != null) {
                slotCarMap.remove(slotNo);
                regNoSlotCarMap.remove(carToLeave.getRegNo());
                List<String> regNoList = colorCarMap.get(carToLeave.getColor());
                if (regNoList.contains(carToLeave.getRegNo())) {
                    regNoList.remove(carToLeave.getRegNo());
                }
                // Add the Lot No. back to available slot list.
                availableCarSlots.add(slotNo);
                System.out.println("Slot number " + slotNo + " is free\n");
            } else {
                System.out.println("Slot number " + slotNo + " is already empty\n");
            }
        } else {
            System.out.println("Parking lot is empty\n");
        }
    }

    public void getStatus() {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created\n");
        } else if (slotCarMap.size() > 0) {
            System.out.println("Slot No.\tRegistration No.\tColor\n");
            Car car;
            for (int i = 1; i <= noOfParkingSlots; i++) {
                if (slotCarMap.containsKey(i)) {
                    car = slotCarMap.get(i);
                    System.out.println(i + "\t" + car.getRegNo() + "\t" + car.getColor());
                }
            }
            System.out.println();
        } else {
            System.out.println("Parking lot is empty\n");
        }
    }

    public void getRegistrationNumbersFromColor(String color) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created\n");
        } else if (colorCarMap.containsKey(color)) {
            List<String> regNoList = colorCarMap.get(color);
            System.out.println();
            for (int i = 0; i < regNoList.size(); i++) {
                if (!(i == regNoList.size() - 1)) {
                    System.out.print(regNoList.get(i) + ",");
                } else {
                    System.out.print(regNoList.get(i));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found\n");
        }
    }

    public void getSlotNumbersFromColor(String color) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created\n");
        } else if (colorCarMap.containsKey(color)) {
            List<String> regNoList = colorCarMap.get(color);
            List<Integer> slotList = new ArrayList<>();
            System.out.println();
            for (int i = 0; i < regNoList.size(); i++) {
                slotList.add(regNoSlotCarMap.get(regNoList.get(i)));
            }
            Collections.sort(slotList);
            for (int j = 0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ", ");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found\n");
        }
    }

    public void getSlotNumberFromRegNo(String regNo) {
        if (noOfParkingSlots == 0) {
            System.out.println("Sorry, parking lot is not created\n");
        } else if (regNoSlotCarMap.containsKey(regNo)) {
            System.out.println(regNoSlotCarMap.get(regNo));
        } else {
            System.out.println("Not found\n");
        }
    }
}
