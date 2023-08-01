package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.TimeDriveCommand;
import frc.robot.subsystems.DriveSubsystem;

public class RotateDriveCommand extends SequentialCommandGroup{

    public RotateDriveCommand(DriveSubsystem m_driveSubsystem, double TimeDriveLeftSpeed, double TimeDriveRightSpeed){

    addCommands(
    new TimeDriveCommand(m_driveSubsystem, 1.75, TimeDriveLeftSpeed, TimeDriveRightSpeed),
    new TimeDriveCommand(m_driveSubsystem, .1, -(TimeDriveLeftSpeed/2), -(TimeDriveRightSpeed/2)),
    
    new TimeDriveCommand(m_driveSubsystem, 1, 0.5, -.5),

    new TimeDriveCommand(m_driveSubsystem, 1.75, TimeDriveLeftSpeed, TimeDriveRightSpeed),
    new TimeDriveCommand(m_driveSubsystem, .1, -(TimeDriveLeftSpeed/2), -(TimeDriveRightSpeed/2)));
    }
}