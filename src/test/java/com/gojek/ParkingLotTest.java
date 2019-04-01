package com.gojek;

import com.gojek.processor.AbstractProcessor;
import com.gojek.processor.CommandLineProcessor;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Author: prabhakar
 * Reviewed By:
 * Project: ParkingLot
 * Created On : 4/1/19
 */
public class ParkingLotTest {
    static AbstractProcessor processor = null;

    @BeforeClass
    public static void setUp() throws Exception {
        processor = new CommandLineProcessor();
        processor.validateAndProcess("create_parking_lot 6");
    }

    @Test
    public void testCreateProcessor() {
        try {
            processor.validateAndProcess("create_parking_lot 6");
        } catch (Exception e) {
            fail("Creation of parking lot failed");
        }

    }

    @Test
    public void testPark() {
        try {
            processor.validateAndProcess("park KA-01-HH-1234 White");
        } catch (Exception e) {
            fail("Creation of parking slot failed");
        }
    }

    @Test
    public void testGetStatus() {
        try {
            processor.validateAndProcess("status");
        } catch (Exception e) {
            fail("Fetching status functionality failed");
        }
    }

    @Test
    public void testGetSlotsByColor() {
        try {
            processor.validateAndProcess("slot_numbers_for_cars_with_colour White");
        } catch (Exception e) {
            fail("slot_numbers_for_cars_with_colour functionality failed");
        }
    }

    @Test
    public void testGetRegNoByColor() {
        try {
            processor.validateAndProcess("registration_numbers_for_cars_with_colour White");
        } catch (Exception e) {
            fail("registration_numbers_for_cars_with_colour functionality failed");
        }
    }

    @Test
    public void testSlotByRegNo() {
        try {
            processor.validateAndProcess("registration_numbers_for_cars_with_colour 1234");
        } catch (Exception e) {
            fail("registration_numbers_for_cars_with_colour functionality failed");
        }
    }

    @Test
    public void testLeave() {
        try {
            processor.validateAndProcess("leave 0");
        } catch (Exception e) {
            fail("leave functionality failed");
        }
    }

}
