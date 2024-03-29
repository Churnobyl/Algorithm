import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] schedules = new int[N][2];

        for (int i = 0; i < N; i++) {
            schedules[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(schedules, Comparator.comparingInt((int[] value) -> value[1]).thenComparingInt((int[] value) -> value[0]));

        int lastEndTime = 0;
        int count = 0;

        for (int i = 0; i < schedules.length; i++) {
            if (lastEndTime <= schedules[i][0]) {
                count++;
                lastEndTime = schedules[i][1];
            }
        }

        System.out.println(count);
    }
}