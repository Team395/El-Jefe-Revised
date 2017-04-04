package org.usfirst.frc.team395.robot.commands;

import org.usfirst.frc.team395.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PullVision extends Command {
	private final byte[] firstMessage = {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x03};
	private final byte[] secondMessage = {(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x04};
	boolean first;
	boolean done = false;
    
	public PullVision(boolean first) {
    	this.first = first;
    }

    protected void initialize() {
    	Robot.serial.write(first ? firstMessage : secondMessage, 16);
    }

    protected void execute() {
    	if(Robot.serial.getBytesReceived() == 16){
			Robot.readString = Robot.serial.readString(16);
			done = true;
    	}
    }

    protected boolean isFinished() {
    	return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
