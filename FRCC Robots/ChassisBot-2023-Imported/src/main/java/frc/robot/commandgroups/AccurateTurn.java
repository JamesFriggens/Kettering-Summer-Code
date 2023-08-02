package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.TimeDriveCommand;
import frc.robot.commands.TurnToDegree;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class AccurateTurn extends SequentialCommandGroup{
        
    public AccurateTurn(DriveSubsystem driveSubsystem, ADXRS450_Gyro gyro, double turnDegrees, double speed){
        
        addCommands(
            new TurnToDegree(driveSubsystem, gyro, turnDegrees, speed),
            new TimeDriveCommand(driveSubsystem, 0.1, -speed, speed)
        );

    }

}
