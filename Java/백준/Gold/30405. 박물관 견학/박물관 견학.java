import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 박물관 견학
 * 박물관은 일렬로 M개가 붙어있고 i번째 전시관에서는  전시 i를 진행함
 * 1 <= i <= M
 * i번째에서 j번째 전시관 사이 이동 거리는 |j - i|
 * 모든 고양이의 이동 거리 합이 최소가 되는 위치에 출입구 설치하려고 함
 * N마리의 고양이가 관람 계획에 따라 이동하고 다시 출입구로 나감
 * 출입구 위치를 계산해주는 프로그램을 만들어라
 */
public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                String museum = st.nextToken();

                if (j == 0 || j == k - 1) {
                    arr[Integer.parseInt(museum)]++;
                }
            }
        }

        long[] prefixWeight = new long[M + 2];
        long[] prefixPositionWeight = new long[M + 2];

        for (int i = 0; i < M + 1; i++) {
            prefixWeight[i + 1] = prefixWeight[i] + arr[i];
            prefixPositionWeight[i + 1] = prefixPositionWeight[i] + (long) i * arr[i];
        }

        long totalWeight = prefixWeight[M + 1];
        long minSum = Long.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < M + 1; i++) {
            long leftSum = i * prefixWeight[i] - prefixPositionWeight[i];
            long rightSum = (prefixPositionWeight[M + 1] - prefixPositionWeight[i]) - i * (totalWeight - prefixWeight[i]);
            long currentSum = leftSum + rightSum;

            if (currentSum < minSum) {
                minSum = currentSum;
                minIdx = i;
            }
        }

        System.out.println(minIdx);
    }
}
