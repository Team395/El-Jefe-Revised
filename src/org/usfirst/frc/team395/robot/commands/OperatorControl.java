package org.usfirst.frc.team395.robot.commands;

import org.usfirst.frc.team395.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperatorControl extends Command {

    public OperatorControl() {
    	requires(Robot.drivebase);
    }

    protected void initialize() {
    	Robot.drivebase.disable();
    }

    protected void execute() {
    	Robot.drivebase.Drive(Robot.oi.driveStick.getY(), Robot.oi.driveStick.getX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivebase.Drive(0,0);
    }

    protected void interrupted() {
    	end();
    }
}
