class Solution {	
    public int solution(int[] stones, int k) {
    	
    	int l = 1;
    	int r = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < stones.length; i++) {
    		if (r < stones[i]) {
    			r = stones[i];
    		}
		}
    	
    	while (l <= r) {
    		int mid = (l + r) / 2;
    		
    		int count = 0;
    		boolean check = false;
    		
    		for (int i = 0; i < stones.length; i++) {
				if (stones[i] < mid) {
					count++;
				} else {
					count = 0;
				}
				
				if (count == k) {
					r = mid - 1;
					check = true;
					break;
				}
			}
    		
    		if (!check) {
    			l = mid + 1;
    		}
    	}
    	
    	return r;
    }
}