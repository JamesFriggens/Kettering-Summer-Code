package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class BalanceCommand extends CommandBase{

    private boolean balance = false;
    DriveSubsystem drivetrain;
    ADXRS450_Gyro gyro;

    public BalanceCommand(DriveSubsystem drivetrain, ADXRS450_Gyro gyro){

        this.drivetrain = drivetrain;
        this.gyro = gyro;
    }

    @Override
    public void initialize(){
        balance = false;
        drivetrain.tankDrive(0.5, 0.5);
    }

    @Override
    public void execute(){

        System.out.println(balance);
        if(gyro.getRate() < -100){
            balance = true;
        
        }
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.tankDrive(0, 0);
    }

    @Override
    public boolean isFinished() {
        
        return balance;

  }
    
}
