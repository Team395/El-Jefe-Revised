package org.usfirst.frc.team395.robot.commands;

import org.usfirst.frc.team395.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClimberControl extends Command {

    public ClimberControl() {
    	requires(Robot.climber);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.climber.driveClimber(Robot.oi.switchOp.getRawAxis(2));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.climber.driveClimber(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
