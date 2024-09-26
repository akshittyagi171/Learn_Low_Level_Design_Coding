package org.lowleveldesigns.Parking_Lot_System_Design.commands;

import org.lowleveldesigns.Parking_Lot_System_Design.OutputPrinter;
import org.lowleveldesigns.Parking_Lot_System_Design.model.Command;
import org.lowleveldesigns.Parking_Lot_System_Design.model.ParkingLot;
import org.lowleveldesigns.Parking_Lot_System_Design.model.parkingStrategy.NaturalOrderingParkingStrategy;
import org.lowleveldesigns.Parking_Lot_System_Design.service.ParkingLotService;
import org.lowleveldesigns.Parking_Lot_System_Design.validator.IntegerValidator;

import java.util.List;

/**
 * Executor to handle command of creating the initial parking lot.
 */
public class CreateParkingLotCommandExecutor extends CommandExecutor {
    public static String COMMAND_NAME = "create_parking_lot";

    public CreateParkingLotCommandExecutor(
            final ParkingLotService parkingLotService, final OutputPrinter outputPrinter) {
        super(parkingLotService, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean validate(final Command command) {
        final List<String> params = command.getParams();
        if (params.size() != 1) {
            return false;
        }
        return IntegerValidator.isInteger(params.get(0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(final Command command) {
        final int parkingLotCapacity = Integer.parseInt(command.getParams().get(0));
        final ParkingLot parkingLot = new ParkingLot(parkingLotCapacity);
        parkingLotService.createParkingLot(parkingLot, new NaturalOrderingParkingStrategy());
        outputPrinter.printWithNewLine(
                "Created a parking lot with " + parkingLot.getCapacity() + " slots");
    }
}
