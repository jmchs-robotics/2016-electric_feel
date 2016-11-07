package frc.team5933.rumble;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import jaci.openrio.toast.lib.module.IterativeModule;

public class RumbleModule extends IterativeModule {

    private BuiltInAccelerometer accel = new BuiltInAccelerometer();
    private Joystick[] joysticks = {
        new Joystick(0),
        new Joystick(1),
        new Joystick(2),
        new Joystick(3),
        new Joystick(4),
        new Joystick(5)
    };

    @Override
    public String getModuleName() {
        return "Team 5933 - Rumble Feedback";
    }

    @Override
    public String getModuleVersion() {
        return "0.2.0";
    }

    /**
     * Called on 'Pre-Initialization' of the robot. This is called before the Robot is indicated as 'ready to go'. Inputs
     * and Outputs should be configured here. This method should not have much over-head
     */
    @Override
    public void prestart() {
        SmartDashboard.putBoolean("Rumble", true);
    }

    /**
     * Called when the Robot has entered Disabled mode. This should be overridden.
     *
     * In this module we only make sure that the Rumblers on the Controllers stop rumbling.
     * If we don't do this the Controllers will continue to rumble until unplugged from the Driver Station.
     */
    @Override
    public void disabledInit() {
        for (Joystick joystick : joysticks) {
            joystick.setRumble(Joystick.RumbleType.kLeftRumble, 0);
            joystick.setRumble(Joystick.RumbleType.kRightRumble, 0);
        }
    }

    /**
     * Called when the Robot has ticked. This happens once every 20ms or once every control
     * packet, whatever comes first. This is for Teleoperated mode.
     */
    @Override
    public void teleopPeriodic() {
        if (SmartDashboard.getBoolean("Rumble")) {
            double accel_z = accel.getZ();

            for (Joystick joystick : joysticks) {
                joystick.setRumble(Joystick.RumbleType.kLeftRumble, (float) Math.abs(accel_z - 1));
                joystick.setRumble(Joystick.RumbleType.kRightRumble, (float) Math.abs(accel_z - 1));
            }
        }
    }
}
