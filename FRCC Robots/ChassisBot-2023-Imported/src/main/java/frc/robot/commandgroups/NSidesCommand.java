package frc.robot.commandgroups;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.commands.TimeDriveCommand;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
//import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.kauailabs.navx.frc.AHRS;

public class NSidesCommand extends SequentialCommandGroup {
    
    public NSidesCommand(DriveSubsystem subsystem, AHRS gyro, int sides){
    
    for(int i = 0; i < sides; i++){
    addCommands(
            new TimeDriveCommand(subsystem, 0.75, 0.5, 0.5),
            new TimeDriveCommand(subsystem, .1, -.25, -.25),
            new WaitCommand(0.2),
            new AccurateTurn(subsystem, gyro, (360/sides), .35),
            new WaitCommand(0.2)
            );
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