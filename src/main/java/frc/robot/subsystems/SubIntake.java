package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class SubIntake extends SubsystemBase {

  private SparkMax m_IntakeM1;
  private SparkMax m_IntakeM2;


  public static SubIntake instance;
  private SparkMaxConfig m_intakeConfig1;
  private SparkMaxConfig m_intakeConfig2;

  //private PIDController m_intakePID1;

  public SubIntake() {

    m_IntakeM1 = new SparkMax(MechanismConstants.kIntakeID, MotorType.kBrushless);
    m_IntakeM2 = new SparkMax(MechanismConstants.kArmID, MotorType.kBrushless);
    //m_intakePID1 = new PIDController(0, 0, 0);


    m_intakeConfig1 = new SparkMaxConfig();
    m_intakeConfig1.smartCurrentLimit(40);
    m_IntakeM1.configure(m_intakeConfig1, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    m_intakeConfig2 = new SparkMaxConfig();
    m_intakeConfig2.smartCurrentLimit(40);
    m_IntakeM2.configure(m_intakeConfig2, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    
  }

  public static SubIntake getInstance(){

    if(instance == null){
      instance = new SubIntake();
    }
    return instance;
  }

  // public double getTurns(){

  //   return m_IntakeM1.getEncoder().getPosition();
  // }

  public void Feed(){
    m_IntakeM1.set(.8);
  }
  public void armDown(){
    m_IntakeM2.set(-.2);
  }
  public void armUp(){
    m_IntakeM2.set(.2);
  }

  public void StopFeed(){
    m_IntakeM1.set(0);
  }
  public void stopArm(){
    m_IntakeM2.set(0);
  }

  @Override
  public void periodic() {
  }
}
