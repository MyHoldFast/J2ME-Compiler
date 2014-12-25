public class Second extends STD {

    public static double a = 0.0;
    public static int a0 = 0;
    public static String a1 = "";
    
    private static boolean isTrue = true;

    static void run(int l) {
        bombom:
        while (isTrue) {
            switch (l) {
                case 10:
                default:
                    a = 0.0;
                    a0 = 0;
                    l = 20;
                    continue;
                case 20:
                    a1 = "Hello, World!";
                    l = 30;
                    continue;
                case 30:
                    _drawText(a1, 0, 40);
                    _repaint();  
                    isTrue = false;
            }
        }
    }
}
