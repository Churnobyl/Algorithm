import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] add;
    static int[][] food;
    static List<Integer>[][] trees;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        add = new int[N][N];
        food = new int[N][N];
        trees = new ArrayList[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                add[i][j] = Integer.parseInt(st.nextToken());
                food[i][j] = 5;
                trees[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            trees[x][y].add(age);
        }

        for (int year = 0; year < K; year++) {
            springAndSummer();
            fall();
            winter();
        }

        System.out.println(countTrees());
    }

    static void springAndSummer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (trees[i][j].isEmpty()) continue;

                Collections.sort(trees[i][j]);
                List<Integer> alive = new ArrayList<>();
                int deadFood = 0;

                for (int age : trees[i][j]) {
                    if (food[i][j] >= age) {
                        food[i][j] -= age;
                        alive.add(age + 1);
                    } else {
                        deadFood += age / 2;
                    }
                }

                food[i][j] += deadFood;
                trees[i][j] = alive;
            }
        }
    }

    static void fall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int age : trees[i][j]) {
                    if (age % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int ny = i + dy[d];
                            int nx = j + dx[d];
                            if (ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                            trees[ny][nx].add(0, 1);
                        }
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                food[i][j] += add[i][j];
            }
        }
    }

    static int countTrees() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt += trees[i][j].size();
            }
        }
        return cnt;
    }
}
