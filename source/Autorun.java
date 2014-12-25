public class Autorun extends STD implements Runnable {

    public static String a = "";
    public static int a0 = 0;

    static void run(int l) {
        bombom:
        while (true) {
            switch (l) {
                case 0:
                default:
                    a = "тест";
                    l = 10;
                    continue;
                case 10:
                    _drawText(a, 0, 0);
                    a0 = 10;
                    l = 20;
                    continue;
                case 20:
                    if (a0 == 10 && (a0 + 10 == 20)) {
                        _drawText("" + a0, 0, 15);
                    }
                    l = 30;
                    continue;
                case 30:
                    _repaint();
                    l = 40;
                    continue;
                case 40:
                    _delay(5000);
                    continue;
            }
        }
    }

    public Autorun() {
        super();
    }

    public void run() {
        try {
            R();
        } catch (Exception ex) {
        }
    }

    public static void R() throws Exception {
        run(-1);
    }

}
