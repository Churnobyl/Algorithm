import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution  {
	static int N, M;
	static int total, bit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < T + 1; i++) {
			sb.append("#" + i + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			boolean isOne = true;
			String binary = Integer.toBinaryString(M);
			
			if (binary.length() < N) {
				sb.append("OFF").append("\n");
				continue;
			}
			
			for (int j = binary.length() - 1; j >= binary.length() - N; j--) {
				if (binary.charAt(j) != '1') {
					isOne = false;
					break;
				}
			}
			
			
			sb.append(isOne ? "ON" : "OFF").append("\n");
		}
		System.out.println(sb);
	}
}