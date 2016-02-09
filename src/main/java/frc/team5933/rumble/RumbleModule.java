package frc.team5933.rumble;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Joystick;
import jaci.openrio.toast.lib.log.Logger;
import jaci.openrio.toast.lib.module.IterativeModule;

public class RumbleModule extends IterativeModule {

    public static Logger logger;
    private BuiltInAccelerometer accel = new BuiltInAccelerometer();
    private Joystick joystick = new Joystick(0);

    @Override
    public String getModuleName() {
        return "Electric Feel - Team 5933 - Rumble Feedback";
    }

    @Override
    public String getModuleVersion() {
        return "0.1.0";
    }

    @Override
    public void robotInit() {
        logger = new Logger("Electric Feel - Team 5933 - Rumble Feedback", Logger.ATTR_DEFAULT);

    }

    /**
     * Called when the Robot has entered Disabled mode. This should be overridden.
     *
     * In this module we only make sure that the Rumblers on the Controller stop rumbling.
     * If we don't do this the Controller will continue to rumble until unplugged from the Driver Station.
     */
    @Override
    public void disabledInit() {
        joystick.setRumble(Joystick.RumbleType.kLeftRumble, 0);
        joystick.setRumble(Joystick.RumbleType.kRightRumble, 0);
    }

    /**
     * Called when the Robot has ticked. This happens once every 20ms or once every control
     * packet, whatever comes first. This is for Teleoperated mode.
     */
    @Override
    public void teleopPeriodic() {
        double accel_z = accel.getZ();

        joystick.setRumble(Joystick.RumbleType.kLeftRumble, (float) Math.abs(accel_z - 1));
        joystick.setRumble(Joystick.RumbleType.kRightRumble, (float) Math.abs(accel_z - 1));
    }
}
