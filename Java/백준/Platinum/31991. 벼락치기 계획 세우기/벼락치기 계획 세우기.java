import java.io.*;
import java.util.*;

public class Main {
    static final double[] scoreTable = {
            0.0, 0.7, 1.0, 1.3, 1.7, 2.0, 2.3, 2.7, 3.0, 3.3, 3.7, 4.0, 4.3
    };
    static final int INF = 1_000_000_000;
    static final int MAX = 52000;

    static class Course {
        int time;
        int credit;
        List<int[]> options;

        Course(int time, int credit) {
            this.time = time;
            this.credit = credit;
            this.options = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Course> courses = new ArrayList<>();
        int creditSum = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int credit = Integer.parseInt(st.nextToken());
            creditSum += credit;

            Course course = new Course(time, credit);

            TreeMap<Integer, Integer> tmp = new TreeMap<>();
            for (int j = 0; j < 13; j++) {
                int need = Integer.parseInt(st.nextToken());
                tmp.put(need, Math.max(tmp.getOrDefault(need, -1), j));
            }

            int maxGrade = -1;
            for (Map.Entry<Integer, Integer> entry : tmp.entrySet()) {
                int need = entry.getKey();
                int grade = entry.getValue();
                if (grade > maxGrade) {
                    course.options.add(new int[]{need, grade});
                    maxGrade = grade;
                }
            }

            courses.add(course);
        }

        courses.sort(Comparator.comparingInt(c -> c.time));
        int[] dp = new int[MAX];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (Course c : courses) {
            int[] nd = new int[MAX];
            Arrays.fill(nd, INF);

            for (int[] opt : c.options) {
                int need = opt[0];
                int grade = opt[1];
                int pts = (int)(c.credit * scoreTable[grade] * 10 + 0.5);

                for (int s = 0; s < MAX; s++) {
                    if (dp[s] == INF) continue;

                    int nt = dp[s] + need;
                    if (nt > c.time) continue;

                    if (s + pts < MAX) {
                        nd[s + pts] = Math.min(nd[s + pts], nt);
                    }
                }
            }

            dp = nd;
        }

        double ans = 0;
        for (int s = 0; s < MAX; s++) {
            if (dp[s] < INF) {
                ans = Math.max(ans, s / 10.0 / creditSum);
            }
        }

        System.out.printf("%.12f\n", ans);
    }
}