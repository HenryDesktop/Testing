package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class SubIndex extends SubsystemBase {

  private static SubIndex m_subIndex;
  private SparkMax m_belt;
  private SparkMaxConfig m_beltConfig;

  public SubIndex() {

    m_belt = new SparkMax(MechanismConstants.kBeltID, MotorType.kBrushless);

    m_beltConfig = new SparkMaxConfig();
    

    m_beltConfig.smartCurrentLimit(40);

    m_belt.configure(m_beltConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
 }

  public static SubIndex getInstance(){

    if(m_subIndex == null)
      m_subIndex = new SubIndex();
    return m_subIndex;
  }

  public void moveFuels(){

    m_belt.set(-0.5);
  }

  public void stop(){

    m_belt.set(0.0);
  }

  @Override
  public void periodic() {

  }
}
