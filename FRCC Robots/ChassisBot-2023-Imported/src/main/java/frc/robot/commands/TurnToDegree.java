package frc.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class TurnToDegree extends CommandBase{

    private DriveSubsystem driveSubsystem;
    private ADXRS450_Gyro gyro;
    private double turnDegrees;
    private double speed;


    public TurnToDegree(DriveSubsystem driveSubsystem, ADXRS450_Gyro gyro, double turnDegrees, double speed){
        addRequirements(driveSubsystem);

        this.driveSubsystem = driveSubsystem;
        this.gyro = gyro;
        this.turnDegrees = turnDegrees;
        this.speed = speed;
        
    }

    @Override
    public void initialize() {
        
        double speed = this.speed;

        if((turnDegrees < 0 && speed > 0) || (turnDegrees > 0 && speed < 0)){
            speed = -speed;
        }

        gyro.reset();

        driveSubsystem.arcadeDrive(0, speed);
    }
    
    @Override
    public void execute() {}

    @Override
    public void end(boolean interrupted){
        driveSubsystem.tankDrive(0, 0);
    }

    @Override
    public boolean isFinished(){

        double degrees = gyro.getAngle();


        

        boolean turningForward = turnDegrees > 0;

        if(turningForward){
            return (degrees >= turnDegrees) && (degrees <= (degrees + 2));
        }

        else{
            return degrees <= turnDegrees;
        }

    }

    
    
}
