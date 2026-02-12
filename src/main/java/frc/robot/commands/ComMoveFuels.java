package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubIndex;

public class ComMoveFuels extends Command {

  public ComMoveFuels() {

    addRequirements(SubIndex.getInstance());
  }

  @Override
  public void initialize() {

    SubIndex.getInstance().moveFuels();
  }


  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {

    SubIndex.getInstance().stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
