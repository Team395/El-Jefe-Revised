package org.usfirst.frc.team395.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class PlaceGear extends CommandGroup {

    public PlaceGear() {
    	addParallel(new PullVision(true));
    	addSequential(new GripperControl(false));
    	addSequential(new Turn(true));
    	addSequential(new DriveDistance(1));
    	addSequential(new Turn(false));
    	addSequential(new PullVision(false));
    	addSequential(new Turn(true));
    	addSequential(new DriveDistance(.5));
    	addSequential(new GripperControl(true));
    	addSequential(new DriveDistance(-72, 1));
    }
}
