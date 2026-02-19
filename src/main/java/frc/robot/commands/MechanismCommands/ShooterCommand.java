
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SubShooter;

public class ComShoot extends Command {

  public ComShoot() {

    addRequirements(SubShooter.getInstance());
  }

  @Override
  public void initialize() {

    SubShooter.getInstance().enablePID(true);
  }

  @Override
  public void execute() {

    
  }

  @Override
  public void end(boolean interrupted) {

    SubShooter.getInstance().enablePID(false);
    SubShooter.getInstance().Stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
