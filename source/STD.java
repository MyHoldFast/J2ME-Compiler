import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.Random;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Spacer;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

public class STD extends Canvas
{
    public static Random RNG;
    public static Image I;
    public static Autorun T;
    public static Graphics G;
    public static int KC;
    public static int KP;

    public static int W;
    public static int H;

    public boolean bPressed;

    public static Player P;
    public static final float E = 2.7182817f;
    public static final float PI = 3.1415927f;
    public static final float SQRT3 = 1.7320508f;
    public static final float LOG10 = 2.3025851f;
    public static final float LOGdiv2 = -0.6931472f;
    private static final AlertType[] alertTypes;
    private static Hashtable bodies;
    private static Random rnd;

    public static float NaNf = Float.NaN;
    
    public STD()
    {
        super();
        setFullScreenMode(true);
        bPressed = false;
        W = getWidth();
        H = getHeight();
    }
    
    public void sizeChanged(int w, int h)
    {
        W = w;
        H = h;
        repaint();
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(I, 0, 0, 20);
    }
    
    public void keyPressed(int keyCode)
    {
        KP = KC = keyCode;
        bPressed = true;
    }
    
    public void keyReleased(int keyCode)
    {
        KP = 0;
        bPressed = false;
    }
        
    public static boolean equals(Object o1, Object o2)
    {
        if (o1 == null)
        {
            return o2 == null;
        }
        if (o2 == null)
        {
            return o1 == null;
        }
        return o1.equals(o2);
    }
    
    public static void _drawArc(int x, int y, int w, int h, int start, int end)
    {
        G.drawArc(x, y, w, h, start, end);
    }
    
    public static void _drawEllipse(int x, int y, int w, int h)
    {
        G.drawArc(x, y, w, h, 0, 360);
    }
    
    public static void _drawImage(Image i, int x, int y)
    {
        G.drawImage(i, x, y, 20);
    }
    
    public static void _drawLine(int x1, int y1, int x2, int y2)
    {
        G.drawLine(x1, y1, x2, y2);
    }
    
    public static void _setFont(int face, int style, int size)
    {
        try
        {
            G.setFont(Font.getFont(face, style, size));
        }
        catch (Throwable t)
        {
            G.setFont(Font.getDefaultFont());
        }
    }
    
    public static void _setColor(int red, int green, int blue)
    {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255)
        {
            return;
        }
        try
        {
            G.setColor(red, green, blue);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }
    
    public static void _setColor(int RGB)
    {
        try
        {
            G.setColor(RGB);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }
    
    public static void _setClip(int x, int y, int width, int height)
    {
        G.setClip(x, y, width, height);
    }
    
    public static int _getColorRed()
    {
        return G.getRedComponent();
    }
    
    public static int _getColorGreen()
    {
        return G.getGreenComponent();
    }
    
    public static int _getColorBlue()
    {
        return G.getBlueComponent();
    }
    
    public static void _fillTriangle(int x1, int y1, int x2, int y2, int x3, int y3)
    {
        G.fillTriangle(x1, y1, x2, y2, x3, y3);
    }
    
    public static void _fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        G.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    
    public static void _fillRect(int x, int y, int width, int height)
    {
        G.fillRect(x, y, width, height);
    }
    
    public static void _fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)
    {
        G.fillArc(x, y, width, height, startAngle, arcAngle);
    }
    
    public static void _fillEllipse(int x, int y, int width, int height)
    {
        G.fillArc(x, y, width, height, 0, 360);
    }
    
    public static void _drawText(String str, int x, int y)
    {
        G.drawString(str, x, y, 20);
    }
    
    public static void _drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        G.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }
    
    public static void _drawRect(int x, int y, int width, int height)
    {
        G.drawRect(x, y, width, height);
    }
    
    public static void _drawChar(char character, int x, int y, int anchor)
    {
        G.drawChar(character, x, y, anchor);
    }
    
    public static int _getColorsNum()
    {
        return FW.fw.display.numColors();
    }
    
    public static int _getHeight()
    {
        return T.getHeight();
    }
    
    public static int _getWidth()
    {
        return T.getWidth();
    }
    
    public static int _getImageHeight(Image im)
    {
        if (im == null)
        {
            return -1;
        }
        return im.getHeight();
    }
    
    public static int _getImageWidth(Image im)
    {
        if (im == null)
        {
            return -1;
        }
        return im.getWidth();
    }
    
    public static int _getStringHeight(String s)
    {
        return G.getFont().getHeight();
    }
    
    public static int _getStringWidth(String s)
    {
        return G.getFont().stringWidth(s);
    }
    
    public static boolean _isColorDisplay()
    {
        return FW.fw.display.isColor();
    }
    
    public static Image _loadImage(String url)
    {
        try
        {
            return Image.createImage(url);
        }
        catch (IOException ex)
        {
        }
        return null;
    }
    
    public static void _plot(int x, int y)
    {
        G.drawLine(x, y, x, y);
    }
    
    public static void _repaint()
    {
        T.repaint();
        T.serviceRepaints();
    }
    
    public static void _setDefaultFont()
    {
        G.setFont(Font.getDefaultFont());
    }
    
    public static int _getKeyClicked()
    {
        return T.KP;
    }
    
    public static int _getKeyPressed()
    {
        if (T.bPressed)
        {
            return T.KP;
        }
        return 0;
    }
    
    public static int _keyToAction(int key)
    {
        return T.getGameAction(key);
    }
    
    public static void _delay(int time)
    {
        try
        {
            Thread.sleep((long) time);
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }
    
    public static int _getCurrentTime()
    {
        return (int) (System.currentTimeMillis() / 1000);
    }
    
    public static int _getDay(int time)
    {
        return getCalendar(time).get(5);
    }
    
    public static int _getHour(int time)
    {
        return getCalendar(time).get(11);
    }
    
    public static int _getMinute(int time)
    {
        return getCalendar(time).get(12);
    }
    
    public static int _getMonth(int time)
    {
        return getCalendar(time).get(2) + 1;
    }
    
    public static int _getRelativeTimeMs()
    {
        return (int) System.currentTimeMillis();
    }
    
    public static int _getSecond(int time)
    {
        return getCalendar(time).get(13);
    }
    
    public static int _getWeekDay(int time)
    {
        return getCalendar(time).get(7) + 1;
    }
    
    public static int _getYear(int time)
    {
        return getCalendar(time).get(1);
    }
    
    public static int _getYearDay(int time)
    {
        Calendar cal = getCalendar(time);
        int fm = 28;
        int year = cal.get(1);
        if (year % 4 == 0 && year % 400 != 0)
        {
            fm++;
        }
        int[] days = new int[]{31, fm, 31, 30, 31, 30, 31, 31, 30, 31};
        int month = cal.get(2);
        int yearDay = 0;
        int i = 0;
        for (; i < month; i++) 
        {
            yearDay += days[i];
        }
        return yearDay + cal.get(5);
    }
    
    private static Calendar getCalendar(int time)
    {
        long millis = (long) time * 1000;
        Calendar cal = Calendar.getInstance();
        Date dt = new Date(millis);
        cal.setTime(dt);
        return cal;
    }
    
    public static float _sin(float i)
    {
        return (float) Math.sin((double) i);
    }
    
    public static float _cos(float i)
    {
        return (float) Math.cos((double) i);
    }
    
    public static float _tan(float a)
    {
        return (float) Math.tan((double) a);
    }
    
    public static float _asin(float x)
    {
        if ((double) x < -1.0 || (double) x > 1.0)
        {
            return NaNf;
        }
        if ((double) x == -1.0)
        {
            return -1.5707964f;
        }
        if (x == 1.0f)
        {
            return 1.5707964f;
        }
        return _atan(x / (float) Math.sqrt((double) (1.0f - x * x)));
    }
    
    public static float _acos(float x)
    {
        float f = _asin(x);
        if (f == NaNf)
        {
            return f;
        }
        return 1.5707964f - f;
    }
    
    public static float _atan(float x)
    {
        boolean signChange = false;
        boolean Invert = false;
        int sp = 0;
        if ((double) x < 0.0)
        {
            x = -x;
            signChange = true;
        }
        if ((double) x > 1.0)
        {
            x = 1.0f / x;
            Invert = true;
        }
        while (x > 0.2617994f)
        {
            sp++;
            float a = x + 1.7320508f;
            a = 1.0f / a;
            x *= 1.7320508f;
            x--;
            x *= a;
        }
        float x2 = x * x;
        float a = x2 + 1.4087812f;
        a = 0.5591371f / a;
        a = (float) ((double) a + 0.60310579);
        a = (float) ((double) a - (double) x2 * 0.05160454);
        for (a *= x; sp > 0; sp--) 
        {
            a += 0.5235988f;
        }
        if (Invert)
        {
            a = 1.5707964f - a;
        }
        if (signChange)
        {
            a = -a;
        }
        return a;
    }
    
    public static float _atan2(float y, float x)
    {
        if ((double) y == 0.0 && (double) x == 0.0)
        {
            return 0.0f;
        }
        if ((double) x > 0.0)
        {
            return _atan(y / x);
        }
        if ((double) x < 0.0)
        {
            if ((double) y < 0.0)
            {
                return -(3.1415927f - _atan(y / x));
            }
            return 3.1415927f - _atan(-y / x);
        }
        if ((double) y < 0.0)
        {
            return -1.5707964f;
        }
        return 1.5707964f;
    }
    
    public static float _toRadians(float angdeg)
    {
        return angdeg / 180.0f * 3.1415927f;
    }
    
    public static float _toDegrees(float angrad)
    {
        return angrad * 180.0f / 3.1415927f;
    }
    
    public static float _exp(float x)
    {
        if ((double) x == 0.0)
        {
            return 1.0f;
        }
        float f = 1.0f;
        long d = 1;
        boolean isless = (double) x < 0.0;
        if (isless)
        {
            x = -x;
        }
        float k = x / (float) d;
        long i = 2;
        for (; i < 50; i++) 
        {
            f += k;
            k = k * x / (float) i;
        }
        if (isless)
        {
            return 1.0f / f;
        }
        return f;
    }
    
    public static float _log(float x)
    {
        if ((double) x <= 0.0)
        {
            return NaNf;
        }
        if ((double) x == 1.0)
        {
            return 0.0f;
        }
        if ((double) x > 1.0)
        {
            x = 1.0f / x;
            return -log(x);
        }
        return log(x);
    }
    
    public static float _sqrt(float num)
    {
        return (float) Math.sqrt((double) num);
    }
    
    public static float _log10(float x)
    {
        return _log(x) / 2.3025851f;
    }
    
    public static float _pow(float x, float y)
    {
        if ((double) y == 0.0)
        {
            return 1.0f;
        }
        if ((double) y == 1.0)
        {
            return x;
        }
        if ((double) x == 0.0)
        {
            return 0.0f;
        }
        if ((double) x == 1.0)
        {
            return 1.0f;
        }
        long l = (long) Math.floor((double) y);
        boolean integerValue = y == (float) l;
        if (integerValue)
        {
            boolean neg = false;
            if ((double) y < 0.0)
            {
                neg = true;
            }
            float result = x;
            long i = 1;
            for (; (!neg || -l < l); i++) 
            {
                result *= x;
            }
            if (neg)
            {
                return 1.0f / result;
            }
            return result;
        }
        if ((double) x > 0.0)
        {
            return _exp(y * _log(x));
        }
        return NaNf;
    }
    
    public static int _trunc(float a)
    {
        return (int) a;
    }
    
    public static float _frac(float a)
    {
        int i = (int) a;
        return _rabs(a - (float) i);
    }
    
    public static float _rabs(float a)
    {
        return Math.abs(a);
    }
    
    private static float log(float x)
    {
        if ((double) x <= 0.0)
        {
            return NaNf;
        }
        float f = 0.0f;
        int appendix = 0;
        for (; (double) x > 0.0; appendix++) 
        {
            if (!((double) x <= 1.0))
            {
                break;
            }
            x = (float) ((double) x * 2.0);
        }
        x = (float) ((double) x / 2.0);
        appendix--;
        float y1 = x - 1.0f;
        float y2 = x + 1.0f;
        float y = y1 / y2;
        float k = y;
        y2 = k * y;
        int i = 1;
        while (i < 50)
        {
            f += k / (float) i;
            k *= y2;
            i += 2;
        }
        f = (float) ((double) f * 2.0);
        for (i = 0; i < appendix; i++) 
        {
            f += -0.6931472f;
        }
        return f;
    }
    
    public static String _copy(String s, int idx1, int idx2)
    {
        if (idx1 < 0)
        {
            idx1 = 0;
        }
        if (idx1 > s.length())
        {
            return "";
        }
        if (idx2 < 0)
        {
            idx2 = s.length() + idx2;
        }
        if (idx2 > s.length())
        {
            idx2 = s.length();
        }
        return s.substring(idx1, idx2);
    }
    
    public static char _getChar(String s, int idx)
    {
        if (idx < 0)
        {
            idx = s.length() + idx;
        }
        if (idx > s.length())
        {
            idx = s.length() - 1;
        }
        return s.charAt(idx);
    }
    
    public static String _integerToString(int i)
    {
        return String.valueOf(i);
    }
    
    public static int _length(String s)
    {
        return s.length();
    }
    
    public static String _locase(String s)
    {
        return toLowerCase(s);
    }
    
    public static int _pos(String s1, String s2)
    {
        return s1.indexOf(s2);
    }
    
    public static String _setChar(String str, char c, int pos)
    {
        if (pos < 0)
        {
            pos = str.length() + pos;
        }
        if (pos > str.length())
        {
            return str;
        }
        StringBuffer sb = new StringBuffer(str);
        sb.setCharAt(pos, c);
        return sb.toString();
    }
    
    public static int _stringToInteger(String s, int base)
    {
        try
        {
            return Integer.parseInt(s, base);
        }
        catch (Throwable t)
        {
        }
        return 0;
    }
    
    public static int _stringToInteger(String s)
    {
        try
        {
            return Integer.parseInt(s);
        }
        catch (Throwable t)
        {
        }
        return 0;
    }
    
    public static float _stringToReal(String s)
    {
        try
        {
            return Float.parseFloat(s);
        }
        catch (Throwable t)
        {
        }
        return 0.0f;
    }
    
    public static String _upcase(String s)
    {
        return toUpperCase(s);
    }
    
    public static String toLowerCase(String s)
    {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (; i < s.length(); i++) 
        {
            sb.append(toLowerCase(s.charAt(i)));
        }
        return sb.toString();
    }
    
    public static char toLowerCase(char c)
    {
        c = Character.toLowerCase(c);
        if (c >= 0x410 && c <= 0x42f)
        {
            return (char) (c + 32);
        }
        if (c == 0x401)
        {
            return 0x451;
        }
        return c;
    }
    
    public static char toUpperCase(char c)
    {
        c = Character.toUpperCase(c);
        if (c >= 0x430 && c <= 0x44f)
        {
            return (char) (c - 32);
        }
        if (c == 0x451)
        {
            return 0x401;
        }
        return c;
    }
    
    public static String toUpperCase(String s)
    {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        for (; i < s.length(); i++) 
        {
            sb.append(toUpperCase(s.charAt(i)));
        }
        return sb.toString();
    }
    
    public static void _addCommand(Command cmd)
    {
        FW.CD.addCommand(cmd);
        FW.LC = null;
    }
    
    public static int _choiceAppendString(int id, String str)
    {
        if (id < 0 || id > FW.F.size())
        {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup))
        {
            return -1;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.append(str, null);
    }
    
    public static int _choiceAppendStringImage(int id, String str, Image im)
    {
        if (id < 0 || id > FW.F.size())
        {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup))
        {
            return -1;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.append(str, im);
    }
    
    public static int _choiceGetSelectedIndex(int id)
    {
        if (id < 0 || id > FW.F.size())
        {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup))
        {
            return -1;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.getSelectedIndex();
    }
    
    public static boolean _choiceIsSelected(int id, int itemId)
    {
        if (id < 0 || id > FW.F.size())
        {
            return false;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof ChoiceGroup))
        {
            return false;
        }
        ChoiceGroup cg = (ChoiceGroup) item;
        FW.LC = null;
        return cg.isSelected(itemId);
    }
    
    public static void _clearForm()
    {
        FW.F.deleteAll();
        FW.LC = null;
    }
    
    public static Command _createCommand(String label, int type, int priority)
    {
        FW.LC = null;
        return new Command(label, type, priority);
    }
    
    public static Command _emptyCommand()
    {
        return null;
    }
    
    public static Command _selectCommand()
    {
        return List.SELECT_COMMAND;
    }
    
    public static int _formAddChoice(String label, int type)
    {
        FW.LC = null;
        return FW.F.append(new ChoiceGroup(label, type));
    }
    
    public static int _formAddGauge(String label, boolean interactive, int max, int init)
    {
        FW.LC = null;
        return FW.F.append(new Gauge(label, interactive, max, init));
    }
    
    public static int _formAddImage(Image i)
    {
        FW.LC = null;
        return FW.F.append(i);
    }
    
    public static int _formAddSpace()
    {
        FW.LC = null;
        return FW.F.append(new Spacer(FW.F.getWidth(), 10));
    }
    
    public static int _formAddString(String label)
    {
        FW.LC = null;
        return FW.F.append(label);
    }
    
    public static int _formAddTextField(String label, String init, int max, int type)
    {
        FW.LC = null;
        return FW.F.append(new TextField(label, init, max, type));
    }
    
    public static String _formGetText(int id)
    {
        FW.LC = null;
        if (id < 0 || id > FW.F.size())
        {
            return "";
        }
        Item item = FW.F.get(id);
        if (!(item instanceof TextField))
        {
            return "";
        }
        TextField tf = (TextField) item;
        return tf.getString();
    }
    
    public static int _formGetValue(int id)
    {
        FW.LC = null;
        if (id < 0 || id > FW.F.size())
        {
            return -1;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof Gauge))
        {
            return -1;
        }
        Gauge gauge = (Gauge) item;
        return gauge.getValue();
    }
    
    public static void _formRemove(int id)
    {
        FW.LC = null;
        if (id < 0 || id > FW.F.size())
        {
            return;
        }
        FW.F.delete(id);
    }
    
    public static void _formSetText(int id, String text)
    {
        FW.LC = null;
        if (id < 0 || id > FW.F.size())
        {
            return;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof TextField))
        {
            return;
        }
        TextField tf = (TextField) item;
        tf.setString(text);
    }
    
    public static void _formSetValue(int id, int value)
    {
        FW.LC = null;
        if (id < 0 || id > FW.F.size())
        {
            return;
        }
        Item item = FW.F.get(id);
        if (!(item instanceof Gauge))
        {
            return;
        }
        Gauge gauge = (Gauge) item;
        gauge.setValue(value);
    }
    
    public static Command _getClickedCommand()
    {
        return FW.LC;
    }
    
    public static String _getTextBoxString()
    {
        FW.LC = null;
        if (FW.TB == null)
        {
            return "";
        }
        return FW.TB.getString();
    }
    
    public static int _menuAppendString(String s)
    {
        FW.LC = null;
        if (FW.L == null)
        {
            return -1;
        }
        return FW.L.append(s, null);
    }
    
    public static int _menuAppendStringImage(String s, Image i)
    {
        FW.LC = null;
        if (FW.L == null)
        {
            return -1;
        }
        return FW.L.append(s, i);
    }
    
    public static int _menuGetSelectedIndex()
    {
        FW.LC = null;
        if (FW.L == null)
        {
            return -1;
        }
        return FW.L.getSelectedIndex();
    }
    
    public static boolean _menuIsSelected(int id)
    {
        FW.LC = null;
        if (FW.L == null)
        {
            return false;
        }
        return FW.L.isSelected(id);
    }
    
    public static void _playAlertSound()
    {
        FW.LC = null;
        if (FW.A == null)
        {
            return;
        }
        AlertType at = FW.A.getType();
        if (at == null)
        {
            return;
        }
        at.playSound(FW.fw.display);
    }
    
    public static void _removeCommand(Command c)
    {
        FW.LC = null;
        FW.F.removeCommand(c);
    }
    
    public static void _setTicker(String label)
    {
        FW.LC = null;
        FW.F.setTicker(new Ticker(label));
    }
    
    public static void _formSetTitle(String title)
    {
        FW.LC = null;
        FW.F.setTitle(title);
    }
    
    public static void _showAlert(String title, String message, Image img, int type)
    {
        AlertType at;
        FW.LC = null;
        if (type < 0 || type >= alertTypes.length)
        {
           at = null;
        }
        else
        {
           at = alertTypes[type];
        }
        FW.A = new Alert(title, title, img, at);
        FW.A.setCommandListener(FW.fw);
        FW.fw.display.setCurrent(FW.A);
        FW.CD = FW.A;
    }
    
    public static void _showCanvas()
    {
        FW.LC = null;
        FW.fw.display.setCurrent(T);
        FW.CD = T;
    }
    
    public static void _showForm()
    {
        FW.LC = null;
        FW.fw.display.setCurrent(FW.F);
        FW.CD = FW.F;
    }
    
    public static void _showMenu(String title, int type)
    {
        FW.LC = null;
        FW.L = new List(title, type);
        FW.L.setCommandListener(FW.fw);
        FW.fw.display.setCurrent(FW.L);
        FW.CD = FW.L;
    }
    
    public static void _showTextBox(String title, String init, int max, int type)
    {
        FW.LC = null;
        FW.TB = new TextBox(title, init, max, type);
        FW.TB.setCommandListener(FW.fw);
        FW.fw.display.setCurrent(FW.TB);
        FW.CD = FW.TB;
    }
    
    public static int _addRecordStoreEntry(RecordStore rs, String data)
    {
        try
        {
            return rs.addRecord(data.getBytes(), 0, data.getBytes().length);
        }
        catch (RecordStoreException ex)
        {
        }
        return -1;
    }
    
    public static void _closeRecordStore(RecordStore rs)
    {
        try
        {
            rs.closeRecordStore();
        }
        catch (RecordStoreException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void _deleteRecordStore(String name)
    {
        try
        {
            RecordStore.deleteRecordStore(name);
        }
        catch (RecordStoreException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static void _deleteRecordStoreEntry(RecordStore rs, int i)
    {
        try
        {
            rs.deleteRecord(i);
        }
        catch (RecordStoreException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static int _getRecordStoreSize(RecordStore rs)
    {
        try
        {
            return rs.getNumRecords();
        }
        catch (RecordStoreException ex)
        {
        }
        return 0;
    }
    
    public static RecordStore _openRecordStore(String name)
    {
        try
        {
            return RecordStore.openRecordStore(name, true);
        }
        catch (RecordStoreException ex)
        {
        }
        return null;
    }
    
    public static String _readRecordStoreEntry(RecordStore rs, int id)
    {
        try
        {
            return new String(rs.getRecord(id));
        }
        catch (RecordStoreException ex)
        {
        }
        return "";
    }
    
    public static void _addHttpBody(HttpConnection http, String body)
    {
        bodies.put(http, body);
    }
    
    public static void _addHttpHeader(HttpConnection http, String name, String value)
    {
        try
        {
            http.setRequestProperty(name, value);
        }
        catch (Exception ex)
        {
        }
    }
    
    public static void _closeHttp(HttpConnection http)
    {
        try
        {
            http.close();
        }
        catch (Exception ex)
        {
        }
    }
    
    public static String _getHttpHeader(HttpConnection http, String name)
    {
        try
        {
            return http.getHeaderField(name);
        }
        catch (Exception ex)
        {
        }
        return "";
    }
    
    public static String _getHttpResponse(HttpConnection http)
    {
        try
        {
            Reader r = new InputStreamReader(http.openInputStream());
            StringBuffer sb = new StringBuffer();
            char[] buf = new char[1024];
            int len = 0;
            while ((len = r.read(buf)) > 0)
            {
                sb.append(buf, 0, len);
            }
            r.close();
            return sb.toString();
        }
        catch (Exception ex)
        {
        }
        return "";
    }
    
    public static boolean _isHttpOpen(HttpConnection http)
    {
        try
        {
            http.getLastModified();
            return true;
        }
        catch (Exception ex)
        {
        }
        return false;
    }
    
    public static HttpConnection _openHttp(String url)
    {
        try
        {
            return (HttpConnection) Connector.open(url);
        }
        catch (Exception ex)
        {
        }
        return null;
    }
    
    public static int _sendHttpMessage(HttpConnection http)
    {
        try
        {
            String body = (String) bodies.get(http);
            if (body != null)
            {
                Writer w = new OutputStreamWriter(http.openOutputStream());
                w.write(body);
                w.close();
            }
            else
            {
                http.openOutputStream();
            }
            return http.getResponseCode();
        }
        catch (Exception ex)
        {
        }
        return -1;
    }
    
    public static void _setHttpMethod(HttpConnection http, String method)
    {
        try
        {
            http.setRequestMethod(method);
        }
        catch (Exception ex)
        {
        }
    }
    
    public static long _getPlayerDuration()
    {
        if (P == null)
        {
            return -1L;
        }
        return P.getDuration();
    }
    
    public static boolean _openPlayer(String url, String mime)
    {
        try
        {
            InputStream is = T.getClass().getResourceAsStream(url);
            P = Manager.createPlayer(is, mime);
            return true;
        }
        catch (Exception ex)
        {
        }
        return false;
    }
    
    public static boolean _setLoopCount(int count)
    {
        if (P == null)
        {
            return false;
        }
        P.setLoopCount(count);
        return true;
    }
    
    public static boolean _startPlayer()
    {
        if (P == null)
        {
            return false;
        }
        try
        {
            P.start();
            return true;
        }
        catch (MediaException ex)
        {
        }
        return false;
    }
    
    public static void _stopPlayer()
    {
        try
        {
            P.stop();
        }
        catch (Exception ex)
        {
            return;
        }
    }
    
    public static void _closeResource(InputStream is)
    {
        try
        {
            is.close();
        }
        catch (IOException ex)
        {
            return;
        }
    }
    
    public static InputStream _openResource(String url)
    {
        return T.getClass().getResourceAsStream(url);
    }
    
    public static int _readByte(InputStream is)
    {
        try
        {
            return is.read();
        }
        catch (Exception ex)
        {
        }
        return -1;
    }
    
    public static String _readLine(InputStream is)
    {
        try
        {
            StringBuffer sb = new StringBuffer();
            int ch = 0;
            while ((ch = is.read()) != 10)
            {
                if ((ch == -1))
                {
                    break;
                }
                sb.append((char) ch);
            }
            if (ch != -1 && sb.toString().length() == 0)
            {
                return _readLine(is);
            }
            return sb.toString();
        }
        catch (Exception ex)
        {
        }
        return "";
    }
    
    public static boolean _resourceAvailable(InputStream is)
    {
        return is != null;
    }
    
    public static char _chr(int ch)
    {
        return (char) ch;
    }
    
    public static String _getProperty(String key)
    {
        String prop = System.getProperty(key);
        if (prop == null)
        {
            return "";
        }
        return prop;
    }
    
    public static void _halt()
    {
        FW.fw.destroyApp(true);
    }
    
    public static int _isMidletPaused()
    {
        return FW.MP;
    }
    
    public static boolean _isBoolPaused()
    {
        return FW.MP < 0;
    }
    
    public static boolean _odd(int i)
    {
        return i % 2 == 1;
    }
    
    public static int _ord(char i)
    {
        return i;
    }
    
    public static int _random(int n)
    {
        return rnd.nextInt(n);
    }
    
    public static void _randomize()
    {
        rnd = RNG = new Random();
    }
    
    void run()
    {
    }
    
    static
    {
        alertTypes = new AlertType[]{AlertType.INFO, AlertType.WARNING, AlertType.ERROR, AlertType.ALARM, AlertType.CONFIRMATION};
        bodies = new Hashtable();
        rnd = RNG = new Random();
    }
    
}