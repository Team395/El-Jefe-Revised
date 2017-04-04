package org.usfirst.frc.team395.robot.commands;

import org.usfirst.frc.team395.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Turn extends Command {

    public Turn(double degrees) {
    	requires(Robot.drivebase);
    	double setpoint = normalizeAngle(Robot.drivebase.gyro.getYaw() + degrees);
    	Robot.drivebase.setSetpoint(setpoint);
    	Robot.drivebase.setDriveSpeed(0);
    }
    public Turn(boolean first){
    	this(Integer.parseInt(Robot.readString.substring(1 + (first ? 0 : 10), 6 + (first ? 0 : 10)))/100);
    }
    
    protected void initialize() {
    	Robot.drivebase.enable();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.drivebase.onTarget();
    }

    protected void end() {
    	Robot.drivebase.disable();
    	Robot.drivebase.setSetpoint(0);
    }

    protected void interrupted() {
    	end();
    }
    
    private double normalizeAngle(double angle)
    {
        double newAngle = angle;
        while (newAngle <= 0) newAngle += 360;
        while (newAngle > 360) newAngle -= 360;
        return newAngle;
    }
}
