// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int RearLeft = 0;
    public static final int FrontLeft = 1;
    public static final int RearRight = 2;
    public static final int FrontRight = 3;

    // Joystick Axes
    public static final int LEFT_X = 0;
    public static final int LEFT_Y = 1;
    public static final int LEFT_TRIGGER = 2;
    public static final int RIGHT_TRIGGER = 3;
    public static final int RIGHT_X = 4;
    public static final int RIGHT_Y = 5;

    // Joystick Buttons
    public static final int JS_A = 1;
    public static final int JS_B = 2;
    public static final int JS_X = 3;
    public static final int JS_Y = 4;
    public static final int JS_LB = 5;
    public static final int JS_RB = 6;
    public static final int JS_BACK = 7;
    public static final int JS_START = 8;
    public static final int JS_L_STICK = 9;
    public static final int JS_R_STICK = 10;

    // Enums
    public static enum AvalButtons {
        A_Y("A/Y"),
        Triggers("Triggers"),
        X_B("X/B"),
        Back_Start("Back/Start"),
        Bumpers("Bumpers");

        public final String label;

        private AvalButtons(String label) {
            this.label = label;
        }
    }

    public static enum AvalDriveModes {
        Arcade("Split Arcade"),
        ArcadeLeft("Left Arcade"),
        ArcadeRight("Right Arcade"),
        TeamworkArcade("Teamwork Arcade"),
        TeamworkTank("Teamwork Tank"),
        Tank("Tank");

        public final String label;

        private AvalDriveModes(String label) {
            this.label = label;
        }
    }
}
