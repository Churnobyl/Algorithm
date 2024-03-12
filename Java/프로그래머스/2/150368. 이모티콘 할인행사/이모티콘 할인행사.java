import java.util.Arrays;

class Solution {
	static int[] growRate;
	static int[] result = new int[2];
	static int[][] userss;
	static int[] emoti;
	
    public static int[] solution(int[][] users, int[] emoticons) {
        growRate = new int[emoticons.length];
        userss = users;
        emoti = emoticons;
        
        for (int i = 0; i < emoticons.length; i++) {
			growRate[i] = emoticons[i] / 10;
		}
        
        recursion(0, new int[users.length]);
        
        return result;
    }
    
    private static void recursion(int idx, int[] userCheck) {
    	if (idx == growRate.length) {
    		int plus = 0;
    		int emo = 0;
    		
    		for (int i = 0; i < userCheck.length; i++) {
				if (userCheck[i] >= userss[i][1]) plus++;
				else emo += userCheck[i];
			}
    		
    		if (result[0] < plus || (result[0] == plus && result[1] < emo)) {
    			result[0] = plus;
    			result[1] = emo;
    		}
    		
    		return;
    	}
    	
    	int price = emoti[idx];
    	
    	for (int i = 1; i <= 4; i++) {
			price -= growRate[idx] ;
			boolean[] a = new boolean[userss.length];
			for (int j = 0; j < userss.length; j++) {
				if (userss[j][0] <= i * 10) {
					userCheck[j] += price;
					a[j] = true;
				}
			}
			recursion(idx + 1, userCheck.clone());
			for (int j = 0; j < userss.length; j++) {
				if (a[j]) userCheck[j] -= price;
			}
		}
    }
    
    public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[][] {{40, 10000}, {25, 10000}}, new int[] {7000, 9000})));
//		System.out.println(Arrays.toString(solution(new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, new int[] {1300, 1500, 1600, 4900})));
	}
}