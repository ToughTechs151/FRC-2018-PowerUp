package org.usfirst.frc.team151.robot.commands;

import org.usfirst.frc.team151.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeElevatorSetpointCommand extends Command {
	
	private boolean isFinished = false;
	private double setpoint = 0;
	
	public ChangeElevatorSetpointCommand(double setpoint) {
		this.setpoint = setpoint;
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		System.out.println("Initializing ChangeElevatorSetpointCommand, setpoint is: " + setpoint);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.ELEVATOR_PID_SUBSYSTEM.changeSetpoint(setpoint);
		Robot.elevatorPIDControl = true;
		Robot.ELEVATOR_PID_SUBSYSTEM.enable();
		isFinished  = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		System.out.println("Finished ChangeElevatorSetpointCommand");
		return isFinished;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
