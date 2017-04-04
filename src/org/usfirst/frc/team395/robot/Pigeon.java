package org.usfirst.frc.team395.robot;

import com.ctre.CANTalon;
import com.ctre.PigeonImu;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class Pigeon implements PIDSource {
	private PigeonImu gyro;
	boolean reverse;
	
	public Pigeon(int deviceNumber, boolean reverse) {
		gyro = new PigeonImu(deviceNumber);
		this.reverse = reverse;
	}

	public Pigeon(CANTalon talonSrx, boolean reverse) {
		gyro = new PigeonImu(talonSrx);
		this.reverse = reverse;
	}
	
	public double getYaw(){
		double YPR[] = new double[3];
		gyro.GetYawPitchRoll(YPR);
		return reverse ? -YPR[0] : YPR[0];
	}
	
	@Override
	public PIDSourceType getPIDSourceType() {
		return PIDSourceType.kDisplacement;
	}
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {}
	
	@Override
	public double pidGet() {
		return this.getYaw();
	}

	

}
