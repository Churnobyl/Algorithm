import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int G;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		G = Integer.parseInt(br.readLine());
		
		int i = 2;
		int j = 1;
		boolean flag = false;
		
		while (i < 100001) {
			int a = (i + j) * (i - j);
			if (a == G) {
				System.out.println(i);
				flag = true;
			}
			
			if (i > j + 1 && a > G) {
				j++;
			} else {
				i++;
			}			
		}
		
		if (!flag) System.out.println(-1);
	}
}