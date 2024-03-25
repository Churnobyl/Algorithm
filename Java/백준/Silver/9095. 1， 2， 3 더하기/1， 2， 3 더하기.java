import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dp = new int[12]; //0~12
        int T = sc.nextInt();
        //점화식: Sn = S(n-1)+S(n-2)+S(n-3)
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<dp.length; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(int i=0; i<T; i++){
            System.out.println(dp[sc.nextInt()]);
        }
    }
}