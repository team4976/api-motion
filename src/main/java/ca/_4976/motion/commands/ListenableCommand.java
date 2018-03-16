package ca._4976.motion.commands;

import ca._4976.motion.Robot;
import ca._4976.motion.data.Initialization;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This is a wrapper for commands that report to the Motion subsystem
 * when a new command is created and run. Use me as an alternative for
 * Command when creating commands that are expected to be recorded
 * for autonomous.
 *
 * @see edu.wpi.first.wpilibj.command.Command
 */
public abstract class ListenableCommand extends Command {

    private final int id;

    ListenableCommand() {

        id = Initialization.commands.size();
        Initialization.commands.add(this);
    }

    @Override public void start() {

        Robot.motion.report(id);
        super.start();
    }
}
