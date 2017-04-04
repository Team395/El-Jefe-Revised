package org.usfirst.frc.team395.robot.subsystems;

import org.usfirst.frc.team395.robot.RobotMap;
import org.usfirst.frc.team395.robot.commands.ClimberControl;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private Talon climberMotor = new Talon(RobotMap.climberMotor);
	
	public Climber(){}
	
	public void driveClimber(double motorSpeed){
		assert(motorSpeed >= 0);
		climberMotor.set(motorSpeed);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberControl());
    }
}

