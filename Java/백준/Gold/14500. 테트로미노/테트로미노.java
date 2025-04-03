import java.io.*;
import java.util.*;

public class Main {
    static int N, M, answer = 0;
    static int[][] map;

    // 모든 테트로미노 19가지 모양 정의
    static int[][][] blocks = {
            // ─, ㅣ
            {{0,0},{0,1},{0,2},{0,3}},
            {{0,0},{1,0},{2,0},{3,0}},
            // 정사각형
            {{0,0},{0,1},{1,0},{1,1}},
            // L자 4개
            {{0,0},{1,0},{2,0},{2,1}},
            {{0,0},{0,1},{0,2},{1,0}},
            {{0,0},{0,1},{1,1},{2,1}},
            {{0,2},{1,0},{1,1},{1,2}},
            // 역L자 4개
            {{0,1},{1,1},{2,1},{2,0}},
            {{0,0},{1,0},{1,1},{1,2}},
            {{0,0},{0,1},{1,0},{2,0}},
            {{0,0},{0,1},{0,2},{1,2}},
            // Z자 2개
            {{0,0},{0,1},{1,1},{1,2}},
            {{0,1},{1,0},{1,1},{2,0}},
            // 역Z자 2개
            {{0,1},{0,2},{1,0},{1,1}},
            {{0,0},{1,0},{1,1},{2,1}},
            // T자 4개
            {{0,0},{0,1},{0,2},{1,1}},
            {{0,1},{1,0},{1,1},{2,1}},
            {{0,1},{1,0},{1,1},{1,2}},
            {{0,0},{1,0},{1,1},{2,0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[][] block : blocks) {
            checkMap(block);
        }

        System.out.println(answer);
    }

    private static void checkMap(int[][] block) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int sum = 0;
                boolean isValid = true;

                for (int k = 0; k < 4; k++) {
                    int y = i + block[k][0];
                    int x = j + block[k][1];

                    if (y < 0 || y >= N || x < 0 || x >= M) {
                        isValid = false;
                        break;
                    }

                    sum += map[y][x];
                }

                if (isValid) {
                    answer = Math.max(answer, sum);
                }
            }
        }
    }
}
