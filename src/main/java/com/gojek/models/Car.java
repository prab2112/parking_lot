package com.gojek.models;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: ParkingLot
 * Created On : 4/1/19
 */
public class Car {
    private String regNo;
    private String color;

    public Car(String regNo, String color) {
        this.regNo = regNo;
        this.color = color;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "regNo='" + regNo + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
