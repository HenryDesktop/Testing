// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
// import frc.robot.commands.ArmCommand;
import frc.robot.commands.ArmDown;
import frc.robot.commands.ArmUp;
import frc.robot.commands.ComFeed;
import frc.robot.commands.ComMoveFuelsB;
import frc.robot.commands.ComMoveFuelsF;
import frc.robot.commands.ComRecolectBalls;
import frc.robot.commands.ComShoot;
import frc.robot.commands.ComShotNOPID;
import frc.robot.subsystems.SubIntake;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {

  private final SubIntake intake = SubIntake.getInstance();

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

     m_driverController.rightBumper().whileTrue(new ComShoot());
    m_driverController.y().whileTrue(new ComFeed());
    m_driverController.leftBumper().whileTrue(new ComShotNOPID());
    m_driverController.a().whileTrue(new ComMoveFuelsB());
    m_driverController.x().whileTrue(new ComMoveFuelsF());
    m_driverController.b().whileTrue(new ComRecolectBalls());

    m_driverController.back().whileTrue(new ArmDown());
    m_driverController.start().whileTrue(new ArmUp());

    // intake.setDefaultCommand(new ArmCommand(m_driverController));
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
