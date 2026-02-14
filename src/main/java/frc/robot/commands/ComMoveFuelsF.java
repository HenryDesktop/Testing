
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubIndex;

public class ComMoveFuelsF extends Command {
  public ComMoveFuelsF() {
    addRequirements(SubIndex.getInstance());
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    SubIndex.getInstance().moveFuelsF();
  }

  @Override
  public void end(boolean interrupted) {
    SubIndex.getInstance().stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
