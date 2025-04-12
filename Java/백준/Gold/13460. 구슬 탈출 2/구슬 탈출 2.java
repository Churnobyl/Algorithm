import java.io.*;
import java.util.*;

public class Main {

    static class State {
        int ry, rx, by, bx, depth;
        State(int ry, int rx, int by, int bx, int depth) {
            this.ry = ry;
            this.rx = rx;
            this.by = by;
            this.bx = bx;
            this.depth = depth;
        }
    }

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int ry = 0, rx = 0, by = 0, bx = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    ry = i;
                    rx = j;
                } else if (board[i][j] == 'B') {
                    by = i;
                    bx = j;
                }
            }
        }

        int result = bfs(ry, rx, by, bx);
        System.out.println(result);
    }

    static int bfs(int ry, int rx, int by, int bx) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(ry, rx, by, bx, 0));
        visited[ry][rx][by][bx] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.depth >= 10) return -1;

            for (int i = 0; i < 4; i++) {
                int[] rResult = move(cur.ry, cur.rx, dy[i], dx[i]);
                int[] bResult = move(cur.by, cur.bx, dy[i], dx[i]);

                int nry = rResult[0], nrx = rResult[1], rCnt = rResult[2];
                int nby = bResult[0], nbx = bResult[1], bCnt = bResult[2];

                if (board[nby][nbx] == 'O') continue;

                if (board[nry][nrx] == 'O') return cur.depth + 1;

                if (nry == nby && nrx == nbx) {
                    if (rCnt > bCnt) {
                        nry -= dy[i];
                        nrx -= dx[i];
                    } else {
                        nby -= dy[i];
                        nbx -= dx[i];
                    }
                }

                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    queue.add(new State(nry, nrx, nby, nbx, cur.depth + 1));
                }
            }
        }

        return -1;
    }

    static int[] move(int y, int x, int dy, int dx) {
        int count = 0;
        while (board[y + dy][x + dx] != '#' && board[y][x] != 'O') {
            y += dy;
            x += dx;
            count++;
            if (board[y][x] == 'O') break;
        }
        return new int[]{y, x, count};
    }
}
