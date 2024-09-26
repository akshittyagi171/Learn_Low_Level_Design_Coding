package org.lowleveldesigns.Parking_Lot_System_Design.exception;

/**
 * Generic exception for general parking lot exceptions.
 */
public class ParkingLotException extends RuntimeException {

    public ParkingLotException() {
    }

    public ParkingLotException(String message) {
        super(message);
    }
}
