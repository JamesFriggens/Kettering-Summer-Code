package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;


import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.Timer;

public class TimeDriveCommand extends CommandBase {

    private final DriveSubsystem m_subsystem;
    private final Timer timer = new Timer();
    private double driveTime;
    private double leftDriveSpeed;
    private double rightDriveSpeed;

    public TimeDriveCommand(DriveSubsystem subsystem, double driveTime, double leftDriveSpeed, double rightDriveSpeed){
        this.driveTime = driveTime;
        this.leftDriveSpeed = leftDriveSpeed;
        this.rightDriveSpeed = rightDriveSpeed;
        m_subsystem = subsystem;

        addRequirements(subsystem);

    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        m_subsystem.tankDrive(leftDriveSpeed, rightDriveSpeed);
    }

    @Override
    public void execute() {}
    

    @Override
    public void end(boolean interrupted) {
        m_subsystem.tankDrive(0, 0);
        timer.stop();
        timer.reset();
    }

    @Override
    public boolean isFinished() {
        
        return timer.get() >= driveTime;

  }
}