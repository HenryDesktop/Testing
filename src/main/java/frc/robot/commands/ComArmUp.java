
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubIntake;

public class ComArmUp extends Command {
  public ComArmUp() {
    addRequirements(SubIntake.getInstance());
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    SubIntake.getInstance().armUp();
  }

  @Override
  public void end(boolean interrupted) {
    SubIntake.getInstance().stopArm();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
