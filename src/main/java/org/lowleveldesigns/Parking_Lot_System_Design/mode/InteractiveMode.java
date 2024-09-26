package org.lowleveldesigns.Parking_Lot_System_Design.mode;

import org.lowleveldesigns.Parking_Lot_System_Design.OutputPrinter;

public class InteractiveMode extends Mode {

    public InteractiveMode(
            final CommandExecutorFactory commandExecutorFactory, final OutputPrinter outputPrinter) {
        super(commandExecutorFactory, outputPrinter);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void process() throws IOException {
        outputPrinter.welcome();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            final String input = reader.readLine();
            final Command command = new Command(input);
            processCommand(command);
            if (command.getCommandName().equals(ExitCommandExecutor.COMMAND_NAME)) {
                break;
            }
        }
    }
}