package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;


import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.Timer;

//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.kauailabs.navx.frc.AHRS;

public class AccurateDriveCommand extends CommandBase {

    private final DriveSubsystem m_subsystem;
    private final Timer timer = new Timer();
    private double driveTime;
    private double leftDriveSpeed;
    private double rightDriveSpeed;

    private AHRS gyro;

    public AccurateDriveCommand(DriveSubsystem subsystem, AHRS gyro, double driveTime, double leftDriveSpeed, double rightDriveSpeed){
        
        this.gyro = gyro;
        this.driveTime = driveTime;
        this.leftDriveSpeed = leftDriveSpeed;
        this.rightDriveSpeed = rightDriveSpeed;
        m_subsystem = subsystem;

        addRequirements(subsystem);

    }

    @Override
    public void initialize() {
        gyro.reset();
        timer.reset();
        timer.start();
        m_subsystem.tankDrive(leftDriveSpeed, rightDriveSpeed);
    }

    @Override
    public void execute() {

        double degrees = gyro.getAngle();

        if (Math.abs(degrees) >= 3) {
            if (degrees < 0) {
                m_subsystem.tankDrive(leftDriveSpeed + .1, rightDriveSpeed);
            } else if (degrees > 0) {
                m_subsystem.tankDrive(leftDriveSpeed, rightDriveSpeed + .1);
            }
        } 
        
        else {
            m_subsystem.tankDrive(leftDriveSpeed, rightDriveSpeed);
        }
    }

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