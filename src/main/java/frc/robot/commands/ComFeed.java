package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubIntake;

public class ComFeed extends Command {
  public ComFeed() {
    addRequirements(SubIntake.getInstance());
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {

      SubIntake.getInstance().Feed();

  }

  @Override
  public void end(boolean interrupted) {
    SubIntake.getInstance().StopFeed();
  }

  @Override
  public boolean isFinished() {

    return false;
  }
}
