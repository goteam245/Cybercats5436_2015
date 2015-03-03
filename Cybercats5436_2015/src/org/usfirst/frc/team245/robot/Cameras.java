package org.usfirst.frc.team245.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;

public class Cameras {
	static int session0;
 	static int session1;
	static Image frame;
	static int curSession;
	public static void camInit() {
		/*
		
		session0 = NIVision.IMAQdxOpenCamera("cam1", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
     	session1 = NIVision.IMAQdxOpenCamera("cam2", NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        curSession = session1;
		setSession( session0 );
		
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
	*/
	}
	public static void setSession(int newSession) {
		/*if(newSession!=curSession){
			NIVision.IMAQdxStopAcquisition(curSession);
			NIVision.IMAQdxConfigureGrab(newSession);
			NIVision.IMAQdxStartAcquisition(newSession);
			curSession = newSession;
		}*/
	}

	public static void updateCamera() {
		NIVision.IMAQdxGrab(curSession, frame, 1);
		CameraServer.getInstance().setImage(frame);
	}


}
