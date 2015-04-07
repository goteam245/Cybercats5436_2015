package org.usfirst.frc.team245.robot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Teleop {
	// get joystick values and call appropriate methods
	// static Joystick joy = new Joystick(1);
	public static boolean exteriorLockAndLift = false;
	public static boolean interiorLift = false;
	public static boolean placeTotes = false;
	public static boolean oldMode = true;
	private static boolean camerasEnabled = false;
	/*
	 * public static File file = new File("GhostMode.txt"); public static
	 * FileWriter f;
	 */

	public static void doWerk() {
		// DRIVE
		 drive();

		// EXTERIOR
		exterior();

		// interior
		interior();
		/*if(camerasEnabled){
		if(Gamepad.secondary.getTriggers()>.3){
			Cameras.setSession(Cameras.session0);
		}
		else{
			Cameras.setSession(Cameras.session0);
		}
		Cameras.updateCamera();*/
	}		

	public static void drive() {
		Drive.Drive.senseMode = oldMode;
		Drive.Drive.DriveSpeed(Gamepad.primary.getLeftX(),
				Gamepad.primary.getLeftY(), Gamepad.primary.getRightX());
		if(Math.abs(Gamepad.primary.getTriggers())>.3){
			oldMode = Drive.Drive.senseMode;
			Drive.Drive.senseMode = false;
			Drive.Drive.DriveSpeed(Gamepad.primary.getTriggers(), 0, 0);
		}
	}

	public static void exterior() {
		
		
		Exterior.Exterior.moveArm(Gamepad.secondary.getRightY());
		if (Gamepad.secondary.getTriggers()<-.3) {
			Exterior.Exterior.setClamps(false);
			SmartDashboard.putBoolean("external clamp", false);
		} else {
			Exterior.Exterior.setClamps(true);
		}
		if(Gamepad.secondary.getLB()){
			Exterior.Exterior.overide= true;
		}
		else{
			Exterior.Exterior.overide=false;
		}
		//if (Gamepad.secondary.getY()) {
			//exteriorLockAndLift = true;
			//Exterior.Exterior.clampAndRiseInit();
		//}
		//if (exteriorLockAndLift) {
			//SmartDashboard.putBoolean("exterior lock and lift", exteriorLockAndLift);
			//exteriorLockAndLift = !Exterior.Exterior.clampAndRise();
		//}
	}

	public static void interior() {
		/*if (Gamepad.secondary.getY()) {
			interiorLift = true;
		}
		if (interiorLift) {
			interiorLift = !Interior.Interior.intakeAndClamp();
		}
		if (Gamepad.secondary.getB() ) {
			placeTotes = true;
		}
		if (interiorLift) {
			placeTotes = !Interior.Interior.placeTotes();
		}*/
		Interior.Interior.moveArm(-.75 * Gamepad.secondary.getLeftY());
		if(Gamepad.secondary.getA()){
			Interior.Interior.toggleClamps(true);
		}
		else{
			Interior.Interior.toggleClamps(false);
		}
		if(Gamepad.secondary.getRB()){
			Interior.Interior.overide= true;
		}
		else{
			Interior.Interior.overide=false;
		}
		if (Gamepad.primary.getA()) {
			Interior.Interior.toggleRollers(-.25, .25);
		}
		else if(Gamepad.primary.getRB()){
			Interior.Interior.toggleRollers(-1, 1);
		}
		else if (Gamepad.primary.getX()) {
			Interior.Interior.toggleRollers(-.5, 0);
		}
		else if (Gamepad.primary.getB()) {
			Interior.Interior.toggleRollers(0, .5);
		}
		else if(Gamepad.primary.getY()){
			Interior.Interior.toggleRollers(.5, -.5);
		}
		else{
			Interior.Interior.toggleRollers(0, 0);
		}
		if(!Gamepad.primary.getLB()){
			Interior.Interior.toggleRollers(true);
		}
		else{
			Interior.Interior.toggleRollers(false);
		}
		/*if(Gamepad.secondary.getX()){
			Interior.Interior.toggleRatchet(true);
		}
		else{
			Interior.Interior.toggleRatchet(false);
		}*/
		
	}

	/*
	 * turns everything off on the robot and removes all functionality because
	 * gabby is a dream crusher
	 */
	public static void gabby() {
		SensorsAndActuators.leftFrontDrive.set(0);
		SensorsAndActuators.leftRearDrive.set(0);
		SensorsAndActuators.rightFrontDrive.set(0);
		SensorsAndActuators.rightRearDrive.set(0);
	}
}
