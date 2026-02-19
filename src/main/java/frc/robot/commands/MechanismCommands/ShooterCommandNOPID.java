
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubShooter;

public class ComShotNOPID extends Command {
  public ComShotNOPID() {
    addRequirements(SubShooter.getInstance());
  }

  @Override
  public void initialize() {

    SubShooter.getInstance().enablePID(false);

  }

  @Override
  public void execute() {
    SubShooter.getInstance().Shoot(.8);
  }

  @Override
  public void end(boolean interrupted) {
    SubShooter.getInstance().Stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
