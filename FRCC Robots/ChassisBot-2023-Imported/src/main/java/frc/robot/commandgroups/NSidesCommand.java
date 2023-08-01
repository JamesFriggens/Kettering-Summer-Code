package frc.robot.commandgroups;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.TimeDriveCommand;

import frc.robot.Constants;
import frc.robot.Constants.AvalDriveModes;
import frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


public class NSidesCommand extends SequentialCommandGroup {
    
    public NSidesCommand(DriveSubsystem subsystem, int sides){
    
    for(int i = 0; i < sides; i++){
    addCommands(
            new TimeDriveCommand(subsystem, 1, 0.5, 0.5),
            new TimeDriveCommand(subsystem, .1, -(0.5/2), -(0.5/2)),
            new TimeDriveCommand(subsystem, (4/sides), 0.75, -0.75));
    }
}
}
//     private final DriveSubsystem m_subsystem;
//     private int sides;

//     public int drawnSides;

//     public NSidesCommand(DriveSubsystem subsystem, int sides){

//         this.sides = sides;
//         m_subsystem = subsystem;

//         addRequirements(subsystem);

//     }

//     @Override
//     public void initialize() {
//         drawnSides = 0;
//     }

//     @Override
//     public void execute() {
//         new TimeDriveCommand(m_subsystem, 1, 0.5, 0.5);
//         new TimeDriveCommand(m_subsystem, (2/sides), 0.5, -0.5);
//         drawnSides += 1;
//     }
  

//     @Override
//     public void end(boolean interrupted) {
//         m_subsystem.tankDrive(0, 0);
//     }

//     @Override
//     public boolean isFinished(){
        
//         return drawnSides == sides;

//   }
// }