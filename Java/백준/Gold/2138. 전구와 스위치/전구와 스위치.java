import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N, cnt;
    static char[] s, e;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        s = sc.next().toCharArray();
        e = sc.next().toCharArray();

        int pressResult = find(true);
        int notPressResult = find(false);

        int result = (pressResult == -1) ?
                notPressResult :
                (notPressResult == -1) ?
                        pressResult :
                        Math.min(pressResult, notPressResult);
        System.out.println(result);
    }

    private static int find(boolean isFirstPressed) {
        char[] switches = s.clone();
        cnt = 0;

        if (isFirstPressed) {
            onOff(switches, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (switches[i - 1] != e[i - 1]) {
                onOff(switches, i);
                cnt++;
            }
        }

        if (switches[N - 1] != e[N - 1]) {
            return -1;
        }

        return cnt;
    }


    private static void onOff(char[] switches, int i) {
        switches[i] = (switches[i] == '0') ? '1' : '0';
        if (i > 0) switches[i - 1] = (switches[i - 1] == '0') ? '1' : '0';
        if (i < N - 1) switches[i + 1] = (switches[i + 1] == '0') ? '1' : '0';
    }
}
