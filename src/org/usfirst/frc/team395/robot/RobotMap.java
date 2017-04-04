package org.usfirst.frc.team395.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	// Drive Train
	public static int leftMotor1 = 0;
	public static int leftMotor2 = 1;
	public static int rightMotor1 = 2;
	public static int rightMotor2 = 3;
	public static int CANGyro = 0;
	
	// Gear
	public static int gripperMotor = 4;
	public static int deployMotor = 5;
	public static int gripperLimitOpen = 0;
	public static int gripperLimitClose = 1;
	
	// Climber
	public static int climberMotor = 6;

}

