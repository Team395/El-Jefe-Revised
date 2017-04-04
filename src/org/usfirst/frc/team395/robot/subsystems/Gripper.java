package org.usfirst.frc.team395.robot.subsystems;

import org.usfirst.frc.team395.robot.RobotMap;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Gripper extends Subsystem {
	private DigitalInput clawOpen = new DigitalInput(RobotMap.gripperLimitOpen);;
	private DigitalInput clawClose = new DigitalInput(RobotMap.gripperLimitClose);
	private Talon gripperMotor = new Talon(RobotMap.gripperMotor);
	private Talon deployMotor = new Talon(RobotMap.deployMotor);
	
	public Gripper(){}
	
	public void driveGripper(double driveSpeed){
		gripperMotor.set(driveSpeed);
	}
	
	public void driveDeploy(double driveSpeed){
		deployMotor.set(1);
	}
	public boolean getOpen(){
		return !clawOpen.get();
	}
	
	public boolean getClose(){
		return !clawClose.get();
	}
	
    public void initDefaultCommand(){}
}

