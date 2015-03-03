package Drive;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team245.robot.Gamepad;
import org.usfirst.frc.team245.robot.SensorsAndActuators;
import org.usfirst.frc.team245.robot.Teleop;

public class Drive {
	private static double oldinputx = 0;
	private static double oldinputy = 0;
	private static Boolean Yaxis = false;
	public static Boolean senseMode = true;
	public static double MAX_ACCEL = .07;
	private static Boolean pressed = false;
	public static ArrayList<Double> yAxis = new ArrayList();
	public static ArrayList<Double> xAxis = new ArrayList();
	public static ArrayList<Double> rotationAxis = new ArrayList();
	public static RobotDrive nathan; 
	 public static double Sensitive(double input){
		SmartDashboard.putNumber("max accel", MAX_ACCEL);	
		 double output = 0;
			if(!Yaxis){
				double delta = input - oldinputx;
				double acceleration = delta;
				if (acceleration > MAX_ACCEL){
					acceleration = MAX_ACCEL;
					delta = acceleration;
					output = oldinputx + delta;
				}else if (acceleration < -MAX_ACCEL){
					acceleration = -MAX_ACCEL;
					delta = acceleration;
					output = oldinputx + delta;
				if (output > 1)
					output = 1;
				}else if (acceleration == 0){
					if (oldinputx > .01){
						output = oldinputx - MAX_ACCEL;
					}
					else if(oldinputx < -.01){
						output = oldinputx + MAX_ACCEL;
					}
					else{
						output = 0;
					}
				} else
					output = input;
					
			oldinputx = output;
			}
			if(Yaxis){
				double delta = input - oldinputy;
				double acceleration = delta;
				if (acceleration > MAX_ACCEL){
					acceleration = MAX_ACCEL;
					delta = acceleration;
					output = oldinputy + delta;
				}else if (acceleration < -MAX_ACCEL){
					acceleration = -MAX_ACCEL;
					delta = acceleration;
					output = oldinputy + delta;
					if (output > 1)
						output = 1;
				}else if (acceleration == 0){
					if (oldinputy > .01){
						output = oldinputy - MAX_ACCEL;
					}
					else if(oldinputy < -.01){
						output = oldinputy + MAX_ACCEL;
					}
					else{
						output = 0;
					}
				} else
						output = input;
				
				oldinputy = output;
				}
			if (!senseMode)
				 output = input;
			
			if (!pressed)
				if (Gamepad.primary.getLeftStick()){
					pressed = true;
					if(!senseMode){
						senseMode = true;
					Teleop.oldMode = true;
					}
					else{
						senseMode = false;
						Teleop.oldMode = false;
					}
				}
			
			if (!Gamepad.primary.getLeftStick())
				pressed = false;
			
			if (Gamepad.primary.getRightStick())
				output = 0;
			SmartDashboard.putBoolean("sensitivity mode:", senseMode);
		return output;
		}
	 
	 public static void DriveSpeed(double X, double Y, double rotation){
			SmartDashboard.putNumber("in x", X);
			SmartDashboard.putNumber("in y", Y);
			Yaxis = false;
		    X = Sensitive(X);
		    Yaxis = true;
		    Y = Sensitive(Y);
		    
		 	//does any needed adjustments then sets motor values
			//first change
			SmartDashboard.putNumber("out x", X);
			SmartDashboard.putNumber("out y", Y);
			SmartDashboard.putNumber("rotation", rotation);
			xAxis.add(X);
			yAxis.add(Y);
			rotationAxis.add(rotation);
			nathan.mecanumDrive_Cartesian(X, Y, rotation, 0);
			
		}
	 public static void init(){
			nathan =new RobotDrive(SensorsAndActuators.leftFrontDrive,
					SensorsAndActuators.leftRearDrive,
					SensorsAndActuators.rightFrontDrive,
					SensorsAndActuators.rightRearDrive);
			nathan.setInvertedMotor(MotorType.kFrontLeft, true);
			nathan.setInvertedMotor(MotorType.kRearLeft, true);

		}
}
	