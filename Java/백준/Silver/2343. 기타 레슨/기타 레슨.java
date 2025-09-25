import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] videos;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        videos = new int[N];
        st = new StringTokenizer(br.readLine());

        int allLength = 0;
        int maxVideoLength = 0;

        for (int i = 0; i < N; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            allLength += videos[i];
            maxVideoLength = Math.max(maxVideoLength, videos[i]);
        }

        int l = maxVideoLength;
        int r = allLength;

        while (l < r) {
            int mid = (l + r) / 2;
            int requireCnt = place(mid);

            if (requireCnt <= M) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }

    private static int place(int offset) {
        int cnt = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + videos[i] > offset) {
                cnt++;
                sum = videos[i];
            } else {
                sum += videos[i];
            }
        }

        return cnt;
    }
}