package org.usfirst.frc.team395.robot.commands;

import org.usfirst.frc.team395.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GripperControl extends Command {
	
	boolean open;
	
    public GripperControl(boolean open){
    	requires(Robot.gripper);
    	this.open = open;
    }

    protected void initialize() {
    	Robot.gripper.driveGripper(open ? (Robot.gripper.getOpen() ? 0.0 : 1.0) : (Robot.gripper.getClose() ? 0.0 : -1.0));
    }

    protected void execute() {}

    protected boolean isFinished() {
        return open ? Robot.gripper.getOpen() : Robot.gripper.getClose();
    }

    protected void end() {
    	Robot.gripper.driveGripper(0);
    }

    protected void interrupted() {
    	end();
    }
}
