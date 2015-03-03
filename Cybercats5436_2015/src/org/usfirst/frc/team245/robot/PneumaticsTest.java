package org.usfirst.frc.team245.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc.team245.robot.SensorsAndActuators;
public class PneumaticsTest {
	public static Timer timer = new Timer();
	public static double lastState = 0;
	static boolean on = true;
	public static void init(){
		timer.start();
	}
	public static void update(){
		if(timer.get()>120){
			if(timer.get()>(lastState+5)&&on){
				SensorsAndActuators.internalToteClamp.set(DoubleSolenoid.Value.kReverse);
				lastState = timer.get();
			}
			else if(timer.get()>(lastState+5)&&!on){
				SensorsAndActuators.internalToteClamp.set(DoubleSolenoid.Value.kForward);
				lastState = timer.get();
			}
			else{
				on = !on;
			}
		}
}
}
