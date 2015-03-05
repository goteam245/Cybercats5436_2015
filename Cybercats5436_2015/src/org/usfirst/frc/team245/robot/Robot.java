package org.usfirst.frc.team245.robot;

import Auton.Test;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */

	private double autonMode = 0;
	private double iteration = 0;

	@Override
	public void robotInit() {

		// SensorsAndActuators.compressor.start();

		SmartDashboard.putString("Init Completed", " ");
		// Auton.LandmarkPlacement.init();
		// SensorsAndActuators.initialize();
		SensorsAndActuators.initialize();
		//SensorsAndActuators.compressor.start();
		//Cameras.camInit();
		 Drive.Drive.init();
		// Drive.Drive.roiInit();
		 ControlsTest.timer.start();
		//PneumaticsTest.init();
	}

	@Override
	public void autonomousInit() {
		// TODO Auto-generated method stub
		super.autonomousInit();
		Auton.DriveForward.iterator=0;
	}

	@Override
	public void autonomousPeriodic() {

		SmartDashboard.putNumber("Auton Mode selected", autonMode);

		// Only one of the two is called, eventually smartdash will decide
		// LandmarkPlacement.update();

		// Auton.Test.update();
		 SmartDashboard.putNumber("auton iterator", Auton.DriveForward.iterator);
		// Cameras.updateCamera();
		 Auton.DriveForward.update();
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	
	public void teleopPeriodic() {
		 try{
		Teleop.doWerk();
		// Auton.Test.update();
		// ControlsTest.update();
		// SmartDashboard.putNumber("Halleffect encoder",
		// SensorsAndActuators.exteriorRotationEncoder.get());
		SmartDashboard.putNumber("exterior motor value", SensorsAndActuators.exteriorLiftMotor.get());
		
		 }
		catch(Exception e){
		SmartDashboard.putString("the exception was:", e.toString());
		
		SmartDashboard.putString("the class of the exception was", e.getStackTrace()[0].getClassName());
		SmartDashboard.putNumber("the line number exception was", e.getStackTrace()[0].getLineNumber());
		// e.printStackTrace();
		}
		 //Cameras.updateCamera();
		//PneumaticsTest.update();
		//ControlsTest.update();
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {

	}

	@Override
	public void disabledPeriodic() {
		// TODO Auto-generated method stub
		super.disabledPeriodic();
		/*autonMode = SmartDashboard.getNumber("Auton Mode selector", -1);
		SmartDashboard.putString("Writing x", Drive.Drive.xValues.toString());
		SmartDashboard.putString("Writing y", Drive.Drive.yValues.toString());
		SmartDashboard.putString("Writing z",
				Drive.Drive.rotationValues.toString());
		SmartDashboard.putBoolean("TOP LIMIT INIT",
				SensorsAndActuators.exteriorTopLimit.get());
		SmartDashboard.putBoolean("BOTTOM LIMIT INIT",
				SensorsAndActuators.exteriorBottomLimit.get());*/
	//SensorsAndActuators.interiorManipulator.reset();	
		SmartDashboard.putString("Writing x", Drive.Drive.xAxis.toString());
		SmartDashboard.putString("Writing y", Drive.Drive.yAxis.toString());
		SmartDashboard.putString("Writing rotation",
				Drive.Drive.rotationAxis.toString());
		Drive.Drive.MAX_ACCEL=SmartDashboard.getNumber("Max acceleration input", .05);
		//Cameras.updateCamera();
	}

}