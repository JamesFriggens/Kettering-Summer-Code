// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {

  private PWMVictorSPX rearRight, frontRight, rearLeft, frontLeft;

  /** Creates a new ExampleSubsystem. */
  public DriveSubsystem() {
    // Instantiate Motors
    rearRight = new PWMVictorSPX(Constants.RearRight);
    frontRight = new PWMVictorSPX(Constants.FrontRight);
    rearLeft = new PWMVictorSPX(Constants.RearLeft);
    frontLeft = new PWMVictorSPX(Constants.FrontLeft);

    // Set Reverse
    rearRight.setInverted(true);
    frontRight.setInverted(true);
  }

  public void arcadeDrive(double forwardSpeed, double turnSpeed) {
    double left = -forwardSpeed + turnSpeed;
    double right = -forwardSpeed - turnSpeed;

    rearRight.set(right);
    frontRight.set(right);
    rearLeft.set(left);
    frontLeft.set(left);
  }

  public void tankDrive(double lSpeed, double rSpeed) {

    rearRight.set(rSpeed);
    frontRight.set(rSpeed);
    rearLeft.set(lSpeed);
    frontLeft.set(lSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
