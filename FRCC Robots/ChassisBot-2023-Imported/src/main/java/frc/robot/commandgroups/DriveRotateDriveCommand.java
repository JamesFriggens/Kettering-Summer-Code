// package frc.robot.commandgroups;

// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.commands.AccurateDriveCommand;
// import frc.robot.commands.TurnToDegree;
// import frc.robot.subsystems.DriveSubsystem;
// import edu.wpi.first.wpilibj.ADXRS450_Gyro;

// public class DriveRotateDriveCommand extends SequentialCommandGroup{

//     DriveSubsystem driveSubsystem;
//     ADXRS450_Gyro gyro;
    
//     DriveRotateDriveCommand(){

//     addCommands(
//         new AccurateDriveCommand(driveSubsystem, 3, 0.4, 0.4),
//         new TurnToDegree(driveSubsystem, gyro, 180, 0.35),
//         new AccurateDriveCommand(driveSubsystem, 3, 0.4, 0.4)

//     );

//     }
// }
