import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		P = new int[N];
		
		int lowValue = Integer.MAX_VALUE;
		int lowIdx = -1;
		
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			if (P[i] < lowValue) {
				lowValue = P[i];
				lowIdx = i;
			}
		}
		
		M = Integer.parseInt(br.readLine());
		int maxLength = M / lowValue;
		int remain = M - lowValue * (maxLength);
		char[] result = new char[maxLength];
		Arrays.fill(result, (char)(lowIdx + '0'));
		
		int startIdx = 0;
		boolean hasMove = true;
		
		for (int i = 0; i < maxLength; i++) {			
			boolean isChangable = false;
			
			int j = 0;
			
			for (j = N - 1; j >= 0; j--) {
				if (lowIdx < j && remain + lowValue - P[j] >= 0) {
					isChangable = true;
					hasMove = false;
					break;
				}
			}
			
			if (isChangable) {
				remain += lowValue - P[j];
				result[i] = (char) (j + '0');
			} else {
				if (hasMove && result[i] == '0') {
					startIdx++;
					remain += lowValue;					
				}
			}
		}
		
		String answer = "";
		
		if (hasMove) {
			startIdx = 0;
		}
		
		boolean isZero = true;
		
		for (int i = startIdx; i < maxLength; i++) {
			answer += result[i];
			if (result[i] != '0') isZero = false;
		}
		
		System.out.println(answer.equals("") || isZero ? 0 : answer);
	}
}       