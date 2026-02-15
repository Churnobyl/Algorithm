import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sh = Integer.parseInt(st.nextToken());
            int sm = Integer.parseInt(st.nextToken());
            int ss = Integer.parseInt(st.nextToken());
            int eh = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());

            int start = sh * 3600 + sm * 60 + ss;
            int end = eh * 3600 + em * 60 + es;
            int diff = end - start;

            int h = diff / 3600;
            diff %= 3600;
            int m = diff / 60;
            int s = diff % 60;

            sb.append(h).append(' ').append(m).append(' ').append(s).append('\n');
        }

        System.out.print(sb.toString());
    }
}
