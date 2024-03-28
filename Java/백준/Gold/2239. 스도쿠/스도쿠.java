import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku;
	static boolean[][] row, col;
	static boolean[][][] square;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sudoku = new int[9][9];
		row = new boolean[9][10];
		col = new boolean[9][10];
		square = new boolean[3][3][10];

		for (int i = 0; i < 9; i++) {
			String line = br.readLine();
			for (int j = 0; j < 9; j++) {
				int data = line.charAt(j) - '0';
				sudoku[i][j] = data;
				row[i][data] = true;
				col[j][data] = true;
				square[i / 3][j / 3][data] = true;
			}
		}
		
		recursion(0, 0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean recursion(int y, int x) {
		if (x == 9) {
			y++;
			x = 0;
		}
		
		if (y > 8) return true;
		
		if (sudoku[y][x] != 0) {
			return recursion(y, x + 1);
		} else {
			for (int i = 1; i < 10; i++) {
				if (row[y][i] || col[x][i] || square[y / 3][x / 3][i]) {
					continue;
				}
				
				sudoku[y][x] = i;
				row[y][i] = true;
				col[x][i] = true;
				square[y / 3][x / 3][i] = true;
				if (recursion(y, x + 1)) {
					return true;
				}
				sudoku[y][x] = 0;
				row[y][i] = false;
				col[x][i] = false;
				square[y / 3][x / 3][i] = false;
			}
		}
		return false;
	}
	
	
}
