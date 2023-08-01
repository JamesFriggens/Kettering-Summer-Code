package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.TimeDriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class DriveAndStopCommand extends SequentialCommandGroup{
    
    public DriveAndStopCommand(DriveSubsystem m_driveSubsystem, double TimeDriveLeftSpeed, double TimeDriveRightSpeed){

        addCommands(
            new TimeDriveCommand(m_driveSubsystem, 3, TimeDriveLeftSpeed, TimeDriveRightSpeed),
            new TimeDriveCommand(m_driveSubsystem, .1, -(TimeDriveLeftSpeed/2), -(TimeDriveLeftSpeed/2))
        );
    }

}
