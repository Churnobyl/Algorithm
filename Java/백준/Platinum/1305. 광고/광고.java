import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int L;
	static String str;
	static int[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		L = Integer.parseInt(br.readLine());
		str = br.readLine();
		str += str;
		p = new int[L];

		int begin = 1;
		int matched = 0;

		while (begin + matched < L) {
			// 맞을 경우
			if (str.charAt(begin + matched) == str.charAt(matched)) {
				matched++;
				p[begin + matched - 1] = matched;
			}

			// 틀렸을 경우
			else {
				if (matched == 0) {
					begin++;
				} else {
					begin += matched - p[matched - 1];
					matched = p[matched - 1];
				}
			}
		}

		System.out.println(L - p[L - 1]);
	}
}