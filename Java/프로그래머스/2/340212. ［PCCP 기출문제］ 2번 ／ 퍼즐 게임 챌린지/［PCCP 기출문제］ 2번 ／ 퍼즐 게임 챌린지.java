import java.util.*;

class Solution {
    static int minBoundary = Integer.MAX_VALUE;
    static int maxBoundary = Integer.MIN_VALUE;
    static int[] diffs;
    static int[] times;
    static long limit;
    
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        findMinMax();
        
        return find();
    }
    
    private void findMinMax() {
        for (int diff : diffs) {
            minBoundary = Math.min(minBoundary, diff);
            maxBoundary = Math.max(maxBoundary, diff);
        }
    }
    
    private int find() {
        int level = 0;
        
        while (minBoundary < maxBoundary) {
            level = (minBoundary + maxBoundary) / 2;
            
            long timeOfSolve = solveProblemUsingLevel(level);
            
            if (timeOfSolve <= limit) {
                maxBoundary = level;
            } else {
                minBoundary = level + 1;
            }
        }
        
        return minBoundary;
    }
    
    private long solveProblemUsingLevel(int level) {
        long time = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                time += times[i];
            } else {
                time += (long)(diffs[i] - level) * (((i > 0) ? times[i - 1] : 0) + times[i]) + times[i];
            }
        }
        
        return time;
    }
}