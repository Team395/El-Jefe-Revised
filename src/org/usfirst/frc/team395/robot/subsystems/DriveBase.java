package org.usfirst.frc.team395.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team395.robot.Pigeon;
import org.usfirst.frc.team395.robot.RobotMap;
import org.usfirst.frc.team395.robot.commands.OperatorControl;
/**
 *
 */


public class DriveBase extends PIDSubsystem {
	
	private RobotDrive robotdrive = new RobotDrive(RobotMap.leftMotor1, RobotMap.leftMotor2, RobotMap.rightMotor1, RobotMap.rightMotor2);
	public Pigeon gyro = new Pigeon(0, true);
	private double driveSpeed;
	
    public DriveBase(){
    	super(0.1, 0.01, 0);
    	setAbsoluteTolerance(1);
    }
    
    public void setDriveSpeed(double driveSpeed){
    	this.driveSpeed = driveSpeed;
    }
    
    public void Drive(double moveValue, double rotateValue){
    	robotdrive.arcadeDrive(moveValue, rotateValue);
    }
    
	@Override
	protected double returnPIDInput() {
		return gyro.getYaw();
	}
	
	@Override
	protected void usePIDOutput(double output) {
		Drive(driveSpeed, output);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new OperatorControl());
	}
    
}

