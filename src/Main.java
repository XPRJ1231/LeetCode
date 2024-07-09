import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String s = code(9);
        System.out.println(s);
    }

    public static String code(int n) {
        String result = "";

        for (int i = 0; i < n; i++) {
            result += rand();
        }

        return result;
    }

    public static char rand() {
        char c;
        Random r = new Random();
        int a = r.nextInt(62);

        if (a <= 9) { // 数字
            c = (char) (a + 48);
        } else if (a > 9 && a <= 35) { // 大写字母
            c = (char) (a - 10 + 65);
        } else { // 小写字母
            c = (char) (a - 36 + 97);
        }

        return c;
    }
}
