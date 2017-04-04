package org.usfirst.frc.team395.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team395.robot.subsystems.*;

public class Robot extends IterativeRobot {
	public static final DriveBase drivebase = new DriveBase();
	public static final Gripper gripper = new Gripper();
	public static final Climber climber = new Climber();
	public static SerialPort serial = new SerialPort(115200, SerialPort.Port.kMXP, 8, SerialPort.Parity.kNone, SerialPort.StopBits.kOne);
	public static OI oi;
	public static String readString;
	@Override
	public void robotInit() {
	    serial.setTimeout(0.005);
	    serial.setFlowControl(SerialPort.FlowControl.kNone);
		serial.setReadBufferSize(16);
		serial.setWriteBufferSize(16);
		serial.setWriteBufferMode(SerialPort.WriteBufferMode.kFlushOnAccess);
		oi = new OI();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
