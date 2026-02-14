// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class SubTakeBalls extends SubsystemBase {
  
    private SparkMax m_ballsIntake;
    private SparkMaxConfig m_ballsIntakeConfig;
      private static SubTakeBalls instance;



  /** Creates a new SubTakeBalls. */
  public SubTakeBalls() {
    m_ballsIntake = new SparkMax(MechanismConstants.kBallsID, MotorType.kBrushless);
    m_ballsIntakeConfig = new SparkMaxConfig();
    m_ballsIntakeConfig.smartCurrentLimit(40);
    m_ballsIntake.configure(m_ballsIntakeConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  public static SubTakeBalls getInstance(){

    if(instance == null){

      instance = new SubTakeBalls();
    }
    return instance;
  }

  public void recolectBalls(){
    m_ballsIntake.set(-0.4);

  }
  public void StopBalls(){

    m_ballsIntake.set(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
