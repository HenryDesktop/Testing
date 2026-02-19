package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubIndex;

public class ComMoveFuelsB extends Command {

  public ComMoveFuelsB() {

    addRequirements(SubIndex.getInstance());
  }

  @Override
  public void initialize() {

    SubIndex.getInstance().moveFuelsB();
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
