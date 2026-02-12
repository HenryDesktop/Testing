package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.util.datalog.DataLog;
import edu.wpi.first.util.datalog.DoubleLogEntry;
import edu.wpi.first.wpilibj.DataLogManager;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MechanismConstants;

public class SubShooter extends SubsystemBase {

  private SparkMax m_shooter1;
  private SparkMax m_shooter2;
  private SparkMax m_shooter3;
  private SparkMax m_ballsIntake;
  
  private SparkMaxConfig m_shooter1Config;
  private SparkMaxConfig m_shooter2Config;
  private SparkMaxConfig m_shooter3Config;
  private SparkMaxConfig m_ballsIntakeConfig;
  private static SubShooter instance;

  private PIDController m_shoot1PID;
  private PIDController m_shoot2PID;

  private boolean pidEnabled;

  private double output1;
  private double output2;
  private double output3;

  private double limitPower = -0.8;
  private double distanceToTag;
  private double sPCalculate;

  public SubShooter() {

    m_shooter1 = new SparkMax(MechanismConstants.kShootmotor1, MotorType.kBrushless);
    m_shooter2 = new SparkMax(MechanismConstants.kShootmotor2, MotorType.kBrushless);
    //m_shooter3 = new SparkMax(MechanismConstants.kShootmotor3, MotorType.kBrushless);  

    m_shooter1Config = new SparkMaxConfig();
    m_shooter2Config = new SparkMaxConfig();
   // m_shooter3Config = new SparkMaxConfig();
    
    m_shooter1Config.smartCurrentLimit(40);
    m_shooter2Config.smartCurrentLimit(40);
    //m_shooter3Config.smartCurrentLimit(40);


    m_shooter1.configure(m_shooter1Config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    m_shooter2.configure(m_shooter2Config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    //m_shooter3.configure(m_shooter3Config, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);


    m_shoot1PID = new PIDController(MechanismConstants.kPAngular, MechanismConstants.kIAngular, MechanismConstants.kDAngular);
    //m_shoot2PID = new PIDController(MechanismConstants.kP, MechanismConstants.kI, MechanismConstants.kD);

    m_shoot1PID.setSetpoint(-4000);
    //m_shoot2PID.setSetpoint(-2000);

    m_shooter2Config.follow(m_shooter2, true);
  }

   public static SubShooter getInstance(){

    if(instance == null){

      instance = new SubShooter();
    }
    return instance;
  }

  public void Shoot(double vel){

    m_shooter1.set(0.8);
    m_shooter2.set(0.8);
  }
  


  public void Stop(){

    m_shooter1.set(0);
    m_shooter2.set(0);
  }
  

  public void enablePID(boolean enable){

    pidEnabled = enable;
  }

  // public boolean readytoShoot(){

  //   return m_shooter1.getEncoder().getVelocity() < -3500;
  // }

  @Override
  public void periodic() {
 
    if(pidEnabled){

      output1 = m_shoot1PID.calculate(m_shooter1.getEncoder().getVelocity());
      //output2 = m_shoot2PID.calculate(m_shooter2.getEncoder().getVelocity());
    }
    else{

      output1 = 0.0;
      output2 = 0.0;
      //output3 = 0.0;
    }

    if(output1 < limitPower) output1 = limitPower;
    //if(output1 > -limitPower) output1 = -limitPower;
    //if(output2 < limitPower) output2 = limitPower;
    //if(output3 < limitPower) output3 = limitPower;

      m_shooter1.set(output1);
    //  m_shooter2.set(output2);

    // SmartDashboard.putNumber("RPM 1", m_shooter1.getEncoder().getVelocity());
    // SmartDashboard.putNumber("RPM 2", m_shooter2.getEncoder().getVelocity());
    
    // SmartDashboard.putNumber("Motor1 Volt", m_shooter1.getBusVoltage());
    // SmartDashboard.putNumber("Motor2 Volt", m_shooter2.getBusVoltage());
    // SmartDashboard.putNumber("Motor3 Volt", m_shooter3.getBusVoltage());

    // SmartDashboard.putNumber("Motor1 OutputCurrent", m_shooter1.getOutputCurrent());
    // SmartDashboard.putNumber("Motor2 OutputCurrent", m_shooter2.getOutputCurrent());
    // SmartDashboard.putNumber("Motor3 OutputCurrent", m_shooter3.getOutputCurrent());


  // if(Math.abs(LimelightHelpers.getBotPose_TargetSpace("")[2]) > 0)
  //   distanceToTag = Math.sqrt(Math.abs(Math.pow(LimelightHelpers.getBotPose_TargetSpace("")[2], 2) - Math.pow(FieldConstants.aprilTagHubHeightM, 2)));
  //   SmartDashboard.putNumber("z", LimelightHelpers.getBotPose_TargetSpace("")[2]);
    
  //   sPCalculate = Conversions.distanceToRPM(distanceToTag);
    //m_shoot2PID.setSetpoint(-sPCalculate);
    SmartDashboard.putNumber("sPCalculate", sPCalculate);
    SmartDashboard.putNumber("DistanceToTag", distanceToTag);
    
  }
}
