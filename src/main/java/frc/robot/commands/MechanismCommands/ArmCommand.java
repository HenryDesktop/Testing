
// package frc.robot.commands;

// import edu.wpi.first.wpilibj.XboxController;
// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
// import frc.robot.subsystems.SubIntake;

// public class ArmCommand extends Command {

//   private final CommandXboxController controller;

//   public ArmCommand(CommandXboxController xboxController) {
//     this.controller = xboxController;
//     addRequirements(SubIntake.getInstance());
//   }

//   @Override
//   public void initialize() {}

//   @Override
//   public void execute() {
//     if (controller.getHID().getStartButtonPressed()){
//           SubIntake.getInstance().armUp();
//     }
//     else if (controller.getHID().getBackButtonPressed()) {
//           SubIntake.getInstance().armDown();
//     }
//     else {
//       SubIntake.getInstance().stopArm();
//     }
//   }

//   @Override
//   public void end(boolean interrupted) {}

//   @Override
//   public boolean isFinished() {
//     return false;
//   }
// }
