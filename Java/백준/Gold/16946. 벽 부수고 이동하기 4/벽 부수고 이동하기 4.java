import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map, grouped, cache, answer;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int groupIndex = 1;
    static List<Integer> groupSize = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        grouped = new int[N][M];
        cache = new int[N][M];
        answer = new int[N][M];
        groupSize.add(0);  // 인덱스 1부터 시작하기 위해 0 추가

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 빈 공간 그룹핑 (BFS 사용)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && grouped[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        // 벽을 부수고 이동할 수 있는 칸 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    answer[i][j] = countAccessibleCells(i, j);
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j] % 10);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        queue.add(new int[]{y, x});
        list.add(new int[]{y, x});
        grouped[y][x] = groupIndex;

        int count = 1;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && grouped[ny][nx] == 0 && map[ny][nx] == 0) {
                    grouped[ny][nx] = groupIndex;
                    queue.add(new int[]{ny, nx});
                    list.add(new int[]{ny, nx});
                    count++;
                }
            }
        }

        for (int[] pos : list) {
            cache[pos[0]][pos[1]] = count;
        }
        groupSize.add(count);
        groupIndex++;
    }

    private static int countAccessibleCells(int y, int x) {
        Set<Integer> visitedGroups = new HashSet<>();
        int count = 1; // 벽을 부수고 자신도 포함

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < M && map[ny][nx] == 0) {
                int group = grouped[ny][nx];
                if (!visitedGroups.contains(group)) {
                    count += groupSize.get(group);
                    visitedGroups.add(group);
                }
            }
        }
        return count;
    }
}
