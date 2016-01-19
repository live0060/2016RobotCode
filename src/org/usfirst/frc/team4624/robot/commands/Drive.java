
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class Drive extends Command {

    public Drive() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setDrive(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setDrive(Robot.oi.xboxController.getRawAxis(1), Robot.oi.xboxController.getRawAxis(0));
    	if (Robot.inputDetector.get()) { //if controller keeps vibrating, then use "!" (not)
    		System.out.printf("Vibrate");
    		new SensorHit().start();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}