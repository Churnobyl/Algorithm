import java.io.*;
import java.util.*;

public class Main {
    static int[] rows = new int[5];
    static int[] cols = new int[5];
    static int diagonal1, diagonal2;
    static boolean diagonalUsed1, diagonalUsed2;
    static Map<Integer, int[]> map = new HashMap<>();
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, new int[] {i, j});
            }
        }

        int result = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                result++;
                int num = Integer.parseInt(st.nextToken());
                int[] p = map.get(num);
                rows[p[0]]++;
                cols[p[1]]++;

                if (p[0] == p[1]) diagonal1++;
                if (p[0] == 4 - p[1]) diagonal2++;

                if (rows[p[0]] == 5) cnt++;
                if (cols[p[1]] == 5) cnt++;
                if (!diagonalUsed1 && diagonal1 == 5) {
                    diagonalUsed1 = true;
                    cnt++;
                }
                if (!diagonalUsed2 && diagonal2 == 5) {
                    diagonalUsed2 = true;
                    cnt++;
                }

                if (cnt >= 3) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}
