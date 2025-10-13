import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] dy = {0, 0, 0, 1, -1};
    static int[] dx = {0, 1, -1, 0, 0};
    static List<Integer> yList = new ArrayList<>();
    static List<Integer> xList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        int y = 0;
        int x = 0;
        String line;

        yList.add(0);
        xList.add(0);

        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) break;
            StringTokenizer st = new StringTokenizer(line);
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            y += len * dy[dir];
            x += len * dx[dir];

            yList.add(y);
            xList.add(x);
        }

        yList.add(0);
        xList.add(0);

        long sum = 0;
        long sub = 0;

        for (int i = 1; i < yList.size(); i++) {
            sum += (long) xList.get(i - 1) * yList.get(i);
            sub += (long) xList.get(i) * yList.get(i - 1);
        }

        System.out.println(Math.abs(sum - sub) * K / 2);
    }
}