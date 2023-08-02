package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.math.controller.PIDController;

public class BalanceCommand extends CommandBase{

    private PIDController pidLoop = new PIDController(0.008, 0.0007, 0);

    DriveSubsystem drivetrain;
    ADXRS450_Gyro gyro;

    public BalanceCommand(DriveSubsystem drivetrain, ADXRS450_Gyro gyro){
        
        this.drivetrain = drivetrain;
        this.gyro = gyro;
        
        // the "range" we can be in for the loop to quit
        pidLoop.setTolerance(5);
        
        // we want to get to gyro angle 0
        pidLoop.setSetpoint(0);
        
    }

    @Override
    public void initialize(){
        drivetrain.tankDrive(0.5, 0.5);
    }

    @Override
    public void execute(){
        drivetrain.arcadeDrive(pidLoop.calculate(gyro.getAngle()) , 0);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        // checking if in the tolerance
        return pidLoop.atSetpoint();
  }
    
}
