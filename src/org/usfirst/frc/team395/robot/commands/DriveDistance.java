package org.usfirst.frc.team395.robot.commands;

import org.usfirst.frc.team395.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveDistance extends Command {
	private final double inchesPerSecond = 85.2;
	private double driveTime;
	private Timer timer;
	
	public DriveDistance(double driveSpeed){
		this(Integer.parseInt(Robot.readString.substring(6, 11))/100, driveSpeed);
	}
    public DriveDistance(double distance, double driveSpeed) {
        requires(Robot.drivebase);
        driveTime = Math.abs(distance/(inchesPerSecond*driveSpeed));
        Robot.drivebase.setDriveSpeed(driveSpeed * (distance > 0 ? 1 : -1));
        Robot.drivebase.setSetpoint(Robot.drivebase.gyro.getYaw());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivebase.enable();
        timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= driveTime;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivebase.disable();
    	Robot.drivebase.setDriveSpeed(0);
    	Robot.drivebase.setSetpoint(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
