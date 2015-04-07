package Exterior;

import java.util.ArrayList;

import org.usfirst.frc.team245.robot.SensorsAndActuators;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Exterior {
	private static Timer timer = new Timer();
	private static final int ARM_ENCODER_MAX = 1500;
	private static final int ROTATION_ENCODER_MAX = 180;
	private static DoubleSolenoid.Value solenoidForward = DoubleSolenoid.Value.kForward;
	private static DoubleSolenoid.Value solenoidReverse = DoubleSolenoid.Value.kReverse;
	public static boolean overide = false;
	public static ArrayList<Double> exteriorSpeed= new ArrayList();
	public static ArrayList<Boolean> exteriorClamp = new ArrayList();
	public static void setClamps(boolean setClamps) {
		if (setClamps) {
			SensorsAndActuators.exteriorArmPiston.set(solenoidForward);
		} else {
			SensorsAndActuators.exteriorArmPiston.set(solenoidReverse);
		}
		exteriorClamp.add(setClamps);
	}

	public static void moveArm(double speed) {
		
		// WARNING - negative speed is up, postive speed is down <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		SmartDashboard.putNumber("arm speed", speed);
		if (speed > 0) {
			//SensorsAndActuators.liftBrake.set(false);
			//if ((SensorsAndActuators.exteriorManipulator.get() < ARM_ENCODER_MAX
					//&& !SensorsAndActuators.exteriorTopLimit.get())||overide||!SensorsAndActuators.exteriorTopLimit.get()) {
// ??? commmented out limit sw, not working			if (overide||!SensorsAndActuators.exteriorBottomLimit.get()) {
			if (overide||!SensorsAndActuators.exteriorBottomLimit.get()) {
				SensorsAndActuators.exteriorLiftMotor.set(speed);
			} else {
				SensorsAndActuators.exteriorLiftMotor.set(0);
			}	
			
		} 
		else if (speed < 0) {
			//SensorsAndActuators.liftBrake.set(false);
			if ( true ) {
				SensorsAndActuators.exteriorLiftMotor.set(speed);
			 
			} else {
				SensorsAndActuators.exteriorLiftMotor.set(0);
			}
			
		} else {
			// TODO SensorsAndActuators.liftBrake.set(true);
			SensorsAndActuators.exteriorLiftMotor.set(0);
		}
		//SensorsAndActuators.exteriorLiftMotor.set(speed);
		//SmartDashboard.putNumber("Encoder Value",
			//	SensorsAndActuators.exteriorManipulator.getDistance());
		SmartDashboard.putBoolean("Exterior Top Limit",
				SensorsAndActuators.exteriorTopLimit.get());
		SmartDashboard.putBoolean("Exterior Bottom Limit",
				SensorsAndActuators.exteriorBottomLimit.get());
		SmartDashboard.putNumber("Encoder Value",
				SensorsAndActuators.exteriorManipulator.get());
		exteriorSpeed.add(speed);
	}

	

	public static void clampAndRiseInit() {
		timer.reset();
		timer.start();
	}

	public static boolean clampAndRise() {
		SmartDashboard.putNumber("timer", timer.get());
		if (timer.get() < 1) {
			Exterior.setClamps(true);
			return false;
		} else {
			Exterior.moveArm(.7);
			if (timer.get() > 3) {
				return true;
			}
			else{
				return false;
			}
		}
		
	}
}
