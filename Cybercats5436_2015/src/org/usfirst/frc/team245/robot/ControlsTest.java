package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team245.robot.SensorsAndActuators;

public class ControlsTest {
	static double testNum = 0;
	public static Timer timer = new Timer();

	public static void update() {
		if (timer.get() > 1) {
			testNum++;
			timer.reset();
		}
		if (testNum < 0)
			testNum = 17;
		if (testNum == 1) {
			 SensorsAndActuators.leftFrontDrive.set(.5);
		}
		if (testNum == 2) {
			 SensorsAndActuators.leftRearDrive.set(.5);
		}
		if (testNum == 3) {
			 SensorsAndActuators.rightFrontDrive.set(.5);
		}
		if (testNum == 4) {
			 SensorsAndActuators.rightRearDrive.set(.5);
		}
		if (testNum == 5) {
			 SensorsAndActuators.leftToteFeederMotor.set(.5);
		}
		if (testNum == 6) {
			 SensorsAndActuators.rightToteFeederMotor.set(.5);
		}
		
		if (testNum == 7) {
			SensorsAndActuators.rollerPiston.set(true);
		}
		if (testNum == 8) {
			SensorsAndActuators.liftBrake.set(true);
		}
		if (testNum == 9) {
			 SensorsAndActuators.interiorLiftMotor.set(.5);
		}
		if (testNum == 10) {
			 SensorsAndActuators.exteriorLiftMotor.set(.5);
		}
		if (testNum == 11) {
			 SensorsAndActuators.exteriorRotationMotor.set(.5);
		}
		if (testNum == 12) {
			SensorsAndActuators.internalToteClamp
					.set(DoubleSolenoid.Value.kForward);
		}
		if (testNum == 13) {
			SensorsAndActuators.internalToteClamp
					.set(DoubleSolenoid.Value.kReverse);
		}
		if (testNum == 14) {
			SensorsAndActuators.exteriorArmPiston
					.set(DoubleSolenoid.Value.kForward);
		}
		if (testNum == 15) {
			SensorsAndActuators.exteriorArmPiston
					.set(DoubleSolenoid.Value.kReverse);
		}
		if (testNum == 16) {
			SensorsAndActuators.ratchetPiston.set(true);
		}
		
		if (testNum == 17) {
			SensorsAndActuators.angleBrake.set(true);
		}// inputPrint();
		SmartDashboard.putNumber("testnum", testNum);
	}

	private static void reset() {
		SensorsAndActuators.angleBrake.set(false);
		SensorsAndActuators.ratchetPiston.set(false);
		SensorsAndActuators.exteriorArmPiston.set(DoubleSolenoid.Value.kOff);
		SensorsAndActuators.internalToteClamp.set(DoubleSolenoid.Value.kOff);
		SensorsAndActuators.exteriorRotationMotor.set(0);
		SensorsAndActuators.exteriorLiftMotor.set(0);
		SensorsAndActuators.interiorLiftMotor.set(0);
		SensorsAndActuators.liftBrake.set(false);
		SensorsAndActuators.rollerPiston.set(false);
		SensorsAndActuators.rightToteFeederMotor.set(0);
		SensorsAndActuators.leftToteFeederMotor.set(0);
		SensorsAndActuators.leftFrontDrive.set(0);
		SensorsAndActuators.leftRearDrive.set(0);
		SensorsAndActuators.rightFrontDrive.set(0);
		SensorsAndActuators.rightRearDrive.set(0);
	}

	private static void inputPrint() {
		SmartDashboard.putNumber("Right rear value",
				SensorsAndActuators.rightRearDrive.get());
		SmartDashboard.putNumber("Right front value",
				SensorsAndActuators.rightFrontDrive.get());
		SmartDashboard.putNumber("Left rear value",
				SensorsAndActuators.leftRearDrive.get());
		SmartDashboard.putNumber("Left front value",
				SensorsAndActuators.leftFrontDrive.get());
		SmartDashboard.putNumber("Right tote feeder value",
				SensorsAndActuators.rightToteFeederMotor.get());
		SmartDashboard.putNumber("Left tote feeder value",
				SensorsAndActuators.leftToteFeederMotor.get());
		SmartDashboard.putNumber("Exterior lift value",
				SensorsAndActuators.exteriorLiftMotor.get());
		SmartDashboard.putNumber("Interior lift value",
				SensorsAndActuators.interiorLiftMotor.get());
		//SmartDashboard.putNumber("Exterior rotation value",
			//	SensorsAndActuators.exteriorRotationMotor.get());
		SmartDashboard.putBoolean("Lift brake value",
				SensorsAndActuators.liftBrake.get());
		SmartDashboard.putBoolean("Clamp piston value",
				SensorsAndActuators.rollerPiston.get());
		SmartDashboard.putBoolean("Angle brake value",
				SensorsAndActuators.angleBrake.get());
		SmartDashboard.putBoolean("Ratchet piston value",
				SensorsAndActuators.ratchetPiston.get());
		SmartDashboard.putString("Exterior arm piston",
				SensorsAndActuators.exteriorArmPiston.getSmartDashboardType());
		SmartDashboard.putString("Tote piston",
				SensorsAndActuators.internalToteClamp.getSmartDashboardType());

		SmartDashboard.putBoolean("Exterior bottom limit",
				SensorsAndActuators.exteriorBottomLimit.get());
		SmartDashboard.putBoolean("Exterior top limit",
				SensorsAndActuators.exteriorTopLimit.get());
		SmartDashboard.putBoolean("Interior bottom limit",
				SensorsAndActuators.interiorBottomLimit.get());
		SmartDashboard.putBoolean("Interior top limit",
				SensorsAndActuators.interiorTopLimit.get());
		SmartDashboard.putBoolean("Photo eye internal",
				SensorsAndActuators.photoEyeInternal.get());
		SmartDashboard.putBoolean("Photo eye external",
				SensorsAndActuators.photoEyeExternal.get());
		SmartDashboard.putNumber("Exterior manipulator",
				SensorsAndActuators.exteriorManipulator.get());
		SmartDashboard.putNumber("Interior manipulator",
				SensorsAndActuators.interiorManipulator.get());
		SmartDashboard.putNumber("Gyro angle",
				SensorsAndActuators.gyro.getAngle());
		SmartDashboard.putNumber("Exterior rotation angle",
				SensorsAndActuators.exteriorRotationEncoder.get());
	}
}
