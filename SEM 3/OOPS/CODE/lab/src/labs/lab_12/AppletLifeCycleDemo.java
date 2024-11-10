package labs.lab_12;

import java.applet.Applet;
import java.awt.Graphics;

/* <applet code="AppletLifeCycleDemo" width="400" height="300"> </applet> */

public class AppletLifeCycleDemo extends Applet {
    // Called once when the applet is initialized
    public void init() {
        System.out.println("Applet Initialized (init method)");
    }

    // Called every time the applet starts or becomes active
    public void start() {
        System.out.println("Applet Started (start method)");
    }

    // Called when the applet becomes inactive or hidden
    public void stop() {
        System.out.println("Applet Stopped (stop method)");
    }

    // Called when the applet is destroyed (only once)
    public void destroy() {
        System.out.println("Applet Destroyed (destroy method)");
    }

    // Display a message on the applet window
    public void paint(Graphics g) {
        g.drawString("Applet Life Cycle Demo", 100, 150);
    }
}

