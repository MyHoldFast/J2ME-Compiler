import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.MIDlet;

public class FW extends MIDlet implements CommandListener
{
    public static FW fw;
    public Autorun m;
    public boolean threadStarted;
    public Display display;
    public static int MP;
    public static Form F;
    public static Displayable CD;
    public static Command LC;
    public static List L;
    public static Alert A;
    public static TextBox TB;

    public FW()
    {
        m = null;
        threadStarted = false;
    }
    
    public void startApp()
    {
        MP = 0;
        display = Display.getDisplay(this);
        fw = this;
        LC = null;
        if (m == null)
        {
            m = new Autorun();
            Autorun.T = m;
            Autorun.I = Image.createImage(m.getWidth(), m.getHeight());
            Autorun.G = Autorun.I.getGraphics();
            Autorun.KC = 0;
            L = new List("", 3);
            A = new Alert("", "", null, AlertType.INFO);
            TB = new TextBox("", "", 2, 0);
            display.setCurrent(m);
            CD = m;
            try
            {
                m.setCommandListener(this);
            }
            catch (Exception exception_1)
            {
            }
            F = new Form("");
            F.setCommandListener(this);
        }
        else
        {
            m.repaint();
            m.serviceRepaints();
        }
        if (!threadStarted)
        {
            new Thread(m).start();
            threadStarted = true;
        }
    }
    
    public void pauseApp()
    {
        MP = -1;
    }
    
    public void destroyApp(boolean boolean_1)
    {
        m = null;
        Autorun.I = null;
        Autorun.G = null;
        CD = null;
        TB = null;
        F = null;
        A = null;
        L = null;
        fw = null;
        LC = null;
        notifyDestroyed();
    }
    
    public void commandAction(Command command_1, Displayable displayable_1)
    {
        LC = command_1;
    }
    
    static
    {
        fw = null;
    }
    
}