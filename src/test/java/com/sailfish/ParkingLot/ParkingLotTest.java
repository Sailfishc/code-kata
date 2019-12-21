package com.sailfish.ParkingLot;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author sailfish
 * @create 2019-12-21-7:14 PM
 */
public class ParkingLotTest {


    @Test
    public void should_park_a_car_to_notFull_parkingLot_is_ok() {
        ParkingLot parkingLot = new ParkingLot();
        assertTrue(parkingLot.park());
    }

    @Test
    public void should_park_a_car_to_full_parkingLot_is_error() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertFalse(parkingLot.park());
    }
}
