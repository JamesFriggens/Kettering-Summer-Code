package frc.robot.commandgroups;

import javax.swing.GroupLayout.SequentialGroup;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.BalanceCommand;
import frc.robot.commands.TimeDriveCommand;
import frc.robot.subsystems.DriveSubsystem;
import com.kauailabs.navx.frc.AHRS;

public class BalanceCommandGroup extends SequentialCommandGroup{
    
    public BalanceCommandGroup(DriveSubsystem drivetrain, AHRS gyro){
        
        addCommands(
        new TimeDriveCommand(drivetrain, 1, 0.5, 0.5),
        new BalanceCommand(drivetrain, gyro)
        );
    }

}
