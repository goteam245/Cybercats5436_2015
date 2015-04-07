package Auton;

import java.io.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonConfig {
		private static int autonCfgIter = 0;
       
       // little crude, class only handles single digit auton mode 0 to 9
       // should plug-in easily - just requires 3 calls to 3 public methods as described below
       
       // ??? is this a good dir/file to write to on roboRio?
       private static final String CONFIG_FILE_NAME = "/home/lvuser/auton_config.txt";
       private static final int DEFAULT_AUTON_MODE = 0;
       
       private static int intendedAutonMode = DEFAULT_AUTON_MODE;
       private static int autonMode = DEFAULT_AUTON_MODE;
       
       // ONLY 3 PUBLIC METHOD7S

       // call from Robot.robotInit()
       public static void init() 
       {
              readAutonConfigFromFile();
              intendedAutonMode = autonMode;
              SmartDashboard.putNumber( "Intended Auton Mode", intendedAutonMode );
              SmartDashboard.putNumber( "Actual Auton Mode (from config file)", autonMode );
       }

       // call from Robot.disablePeriodic()
       public static void update()
       {
              intendedAutonMode = (int)SmartDashboard.getNumber( "Intended Auton Mode");
              autonCfgIter++;
              SmartDashboard.putNumber( "autonCfg iter", autonCfgIter );
              
              
              if ( intendedAutonMode != autonMode ) {
                     writeAutonConfigToFile( intendedAutonMode );

                     // read back and output to dashboard
                     readAutonConfigFromFile();
                     SmartDashboard.putNumber( "Intended Auton Mode", intendedAutonMode );
                     SmartDashboard.putNumber( "Actual Auton Mode (from config file)", autonMode );
              }
       }

       // call from Robot.autonomousInit() to get autonMode when ready to pull trigger on autonomous- 
       public static int getAutonMode()
       {
              return( autonMode );
       }
       
       
       // REST OF METHODS ARE PRIVATE
       
       private static void readAutonConfigFromFile() 
       {
              FileInputStream configFileStream = null;
              int c;

              autonMode = DEFAULT_AUTON_MODE;

              try {
                     // check if file exists
                     if ( new File( CONFIG_FILE_NAME ).exists() ) { 
                            configFileStream = new FileInputStream( CONFIG_FILE_NAME );
                           if ( ( c = configFileStream.read() ) != -1 ) {
                                  // little crude, but stored as ascii so easy to human read file, so value of 0 is ASCII 48
                                  autonMode = c - 48;

                           }                   
                     }

                     if ( configFileStream != null ) {
                           configFileStream.close();
                     }
              }
              catch (Exception e) {
                     SmartDashboard.putString("the exception was:", e.toString());
                     SmartDashboard.putString("the class of the exception was", e.getStackTrace()[0].getClassName());
                     SmartDashboard.putNumber("the line number exception was", e.getStackTrace()[0].getLineNumber());                 
              }
       }
       
       private static void writeAutonConfigToFile( int writeAutonMode ) 
       {
              FileOutputStream configFileStream = null;
              try {
                     configFileStream = new FileOutputStream( CONFIG_FILE_NAME );
                     // little crude, but stored as ascii so easy to human read file, so value of 0 is ASCII 48
                     configFileStream.write( writeAutonMode + 48  );

                     if ( configFileStream != null ) {
                           configFileStream.close();
                     }
                     intendedAutonMode = writeAutonMode;
              }
              catch (Exception e) {
                     SmartDashboard.putString("the exception was:", e.toString());
                     SmartDashboard.putString("the class of the exception was", e.getStackTrace()[0].getClassName());
                     SmartDashboard.putNumber("the line number exception was", e.getStackTrace()[0].getLineNumber());                 
              }
       }
}

