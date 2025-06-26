import java.io.*;
import java.util.*;

public class Main {
    static int N, maxBlock;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                board[i][j]=Integer.parseInt(st.nextToken());
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }
        dfs(board, 0);
        System.out.println(maxBlock);
    }

    static void dfs(int[][] board, int depth) {
        if(depth == 10) return;
        for(int dir = 0; dir < 4; dir++) {
            int[][] moved;
            if(dir == 0) moved = moveLeft(board);
            else if(dir == 1) moved = moveRight(board);
            else if(dir == 2) moved = moveUp(board);
            else moved = moveDown(board);

            if(!isSame(board, moved)) {
                dfs(moved, depth + 1);
            }
        }
    }

    static int[][] moveLeft(int[][] board) {
        int[][] newBoard = new int[N][N];
        for(int i=0;i<N;i++) {
            int[] temp = new int[N];
            int idx = 0;
            boolean merged = false;
            for(int j=0;j<N;j++) {
                if(board[i][j]==0) continue;
                if(idx > 0 && temp[idx-1]==board[i][j] && !merged) {
                    temp[idx-1]*=2;
                    maxBlock=Math.max(maxBlock,temp[idx-1]);
                    merged=true;
                } else {
                    temp[idx++]=board[i][j];
                    merged=false;
                }
            }
            newBoard[i]=temp;
        }
        return newBoard;
    }

    static int[][] moveRight(int[][] board) {
        int[][] newBoard = new int[N][N];
        for(int i=0;i<N;i++) {
            int[] temp = new int[N];
            int idx = N-1;
            boolean merged = false;
            for(int j=N-1;j>=0;j--) {
                if(board[i][j]==0) continue;
                if(idx < N-1 && temp[idx+1]==board[i][j] && !merged) {
                    temp[idx+1]*=2;
                    maxBlock=Math.max(maxBlock,temp[idx+1]);
                    merged=true;
                } else {
                    temp[idx--]=board[i][j];
                    merged=false;
                }
            }
            newBoard[i]=temp;
        }
        return newBoard;
    }

    static int[][] moveUp(int[][] board) {
        int[][] newBoard = new int[N][N];
        for(int j=0;j<N;j++) {
            int[] temp = new int[N];
            int idx = 0;
            boolean merged = false;
            for(int i=0;i<N;i++) {
                if(board[i][j]==0) continue;
                if(idx > 0 && temp[idx-1]==board[i][j] && !merged) {
                    temp[idx-1]*=2;
                    maxBlock=Math.max(maxBlock,temp[idx-1]);
                    merged=true;
                } else {
                    temp[idx++]=board[i][j];
                    merged=false;
                }
            }
            for(int i=0;i<N;i++) newBoard[i][j]=temp[i];
        }
        return newBoard;
    }

    static int[][] moveDown(int[][] board) {
        int[][] newBoard = new int[N][N];
        for(int j=0;j<N;j++) {
            int[] temp = new int[N];
            int idx = N-1;
            boolean merged = false;
            for(int i=N-1;i>=0;i--) {
                if(board[i][j]==0) continue;
                if(idx < N-1 && temp[idx+1]==board[i][j] && !merged) {
                    temp[idx+1]*=2;
                    maxBlock=Math.max(maxBlock,temp[idx+1]);
                    merged=true;
                } else {
                    temp[idx--]=board[i][j];
                    merged=false;
                }
            }
            for(int i=0;i<N;i++) newBoard[i][j]=temp[i];
        }
        return newBoard;
    }

    static boolean isSame(int[][] a, int[][] b) {
        for(int i=0;i<N;i++)
            if(!Arrays.equals(a[i], b[i]))
                return false;
        return true;
    }
}
