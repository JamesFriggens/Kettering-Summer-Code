package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;

public class BalanceCommand extends CommandBase{

    private PIDController pidLoop = new PIDController(0.016, 0.0007, 0);

    DriveSubsystem drivetrain;
    AHRS gyro;

    public BalanceCommand(DriveSubsystem drivetrain, AHRS gyro){
        
        this.drivetrain = drivetrain;
        this.gyro = gyro;
        
        // the "range" we can be in for the loop to quit
        pidLoop.setTolerance(5);
        
        // we want to get to gyro angle 0
        pidLoop.setSetpoint(0);
        
    }

    @Override
    public void initialize(){
        // drivetrain.tankDrive(0.5, 0.5);
    }

    @Override
    public void execute(){

        SmartDashboard.putNumber("pidLoop calculating value", -pidLoop.calculate(gyro.getPitch()));
        drivetrain.arcadeDrive(-pidLoop.calculate(gyro.getPitch()) , 0);
        // drivetrain.arcadeDrive(-pidLoop.calculate(gyro.getPitch()) , -pidLoop.calculate(gyro.getPitch()));
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        // checking if in the tolerance
        return false;
  }
    
}
