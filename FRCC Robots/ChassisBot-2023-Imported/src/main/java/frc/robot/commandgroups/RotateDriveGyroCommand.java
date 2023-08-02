package frc.robot.commandgroups;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.TimeDriveCommand;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class RotateDriveGyroCommand extends SequentialCommandGroup{

    public RotateDriveGyroCommand(DriveSubsystem subsystem, ADXRS450_Gyro gyro){

    addCommands(
    new TimeDriveCommand(subsystem, 1.5, 0.5, 0.5),
   new TimeDriveCommand(subsystem, 0.1, -0.25, -0.25),
    
   new AccurateTurn(subsystem, gyro, 180, .35),

   new TimeDriveCommand(subsystem, 1.5, 0.5, 0.5),
    new TimeDriveCommand(subsystem, 0.1, -0.25, -0.25));
    }
}