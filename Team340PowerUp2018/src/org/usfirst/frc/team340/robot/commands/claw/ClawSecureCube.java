package org.usfirst.frc.team340.robot.commands.claw;

import org.usfirst.frc.team340.robot.Robot;
import org.usfirst.frc.team340.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */

public class ClawSecureCube extends Command {

    public ClawSecureCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	System.out.println("CLAW SECURE CUBE STARTING");
    	Robot.claw.spinWheelsIn(RobotMap.CLAW_WHEEL_HOLDSPEED_VBUS);
    	Robot.claw.close();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.claw.isCubePresent(); //To be determined
    }	

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
