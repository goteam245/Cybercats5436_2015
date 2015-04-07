package Auton;

public class LandfillForward {
	public static double[] yValues = {0,.05,.1,.15,.2,.25,.3,.35,.4,.45,.45,.45,.45,.45,.45,.45,.4,.3,.27,.25,.2,.15,.1,.05,0};
	public static int iterator=0;
	public static void update() {
		if (iterator < yValues.length) {
			Drive.Drive.DriveSpeed(0, yValues[iterator],0);
		} else {
			Drive.Drive.DriveSpeed(0, 0, 0);
		}
		iterator++;
	}
}
