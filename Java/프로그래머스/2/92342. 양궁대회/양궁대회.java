import java.util.*;

class Solution {
    static int maxDiff = -1;
    static int[] answer = {-1};
    
    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];
        
        dfs(0, n, info, ryan);
        
        return answer;
    }
    
    private void dfs(int idx, int remain, int[] info, int[] ryan) {
        if (idx == 11 || remain == 0) {
            ryan[10] += remain;
            
            int ryanScore = 0;
            int apeachScore = 0;
            
            for (int i = 0; i < 11; i++) {
                int point = 10 - i;
                
                if (info[i] == 0 && ryan[i] == 0) {
                    continue;
                } else if (ryan[i] > info[i]) {
                    ryanScore += point;
                } else {
                    apeachScore += point;
                }
            }
            
            int diff = ryanScore - apeachScore;
            
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff;
                    answer = ryan.clone();
                } 
                else if (diff == maxDiff) {
                    if (isLowerScorePreferred(ryan, answer)) {
                        answer = ryan.clone();
                    }
                }
            }
            
            ryan[10] -= remain;
            return;
        }
        
        if (remain > info[idx]) {
            ryan[idx] = info[idx] + 1;
            dfs(idx + 1, remain - ryan[idx], info, ryan);
            ryan[idx] = 0;
        }
        
        dfs(idx + 1, remain, info, ryan);
    }
    
    private boolean isLowerScorePreferred(int[] newArr, int[] oldArr) {
        for (int i = 10; i >= 0; i--) {
            if (newArr[i] != oldArr[i]) {
                return newArr[i] > oldArr[i];
            }
        }
        return false;
    }
}