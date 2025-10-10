import java.util.*;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int half = n / 2;
        
        // 1. 모든 조합 생성
        List<int[]> combinations = new ArrayList<>();
        generateCombinations(n, half, 0, new int[half], 0, combinations);
        
        int maxWins = -1;
        int[] answer = null;
        
        // 2. 각 조합마다 승수 계산
        for (int[] aChoice : combinations) {
            int[] bChoice = getComplement(aChoice, n);
            
            // A와 B의 가능한 합 분포 계산
            Map<Integer, Integer> aSums = calculateSumDistribution(dice, aChoice);
            Map<Integer, Integer> bSums = calculateSumDistribution(dice, bChoice);
            
            // 승수 계산
            int wins = countWins(aSums, bSums);
            
            if (wins > maxWins) {
                maxWins = wins;
                answer = aChoice.clone();
            }
        }
        
        // 3. 1-indexed로 변환
        for (int i = 0; i < answer.length; i++) {
            answer[i]++;
        }
        
        return answer;
    }
    
    // 조합 생성 (0-indexed)
    private void generateCombinations(int n, int r, int start, int[] current, int depth, List<int[]> result) {
        if (depth == r) {
            result.add(current.clone());
            return;
        }
        
        for (int i = start; i < n; i++) {
            current[depth] = i;
            generateCombinations(n, r, i + 1, current, depth + 1, result);
        }
    }
    
    // 보수 집합 구하기
    private int[] getComplement(int[] subset, int n) {
        Set<Integer> subsetSet = new HashSet<>();
        for (int num : subset) {
            subsetSet.add(num);
        }
        
        List<Integer> complement = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!subsetSet.contains(i)) {
                complement.add(i);
            }
        }
        
        return complement.stream().mapToInt(i -> i).toArray();
    }
    
    // 주사위 조합의 합 분포 계산
    private Map<Integer, Integer> calculateSumDistribution(int[][] dice, int[] indices) {
        Map<Integer, Integer> current = new HashMap<>();
        current.put(0, 1);
        
        for (int idx : indices) {
            Map<Integer, Integer> next = new HashMap<>();
            
            for (int face : dice[idx]) {
                for (Map.Entry<Integer, Integer> entry : current.entrySet()) {
                    int sum = entry.getKey() + face;
                    int count = entry.getValue();
                    next.put(sum, next.getOrDefault(sum, 0) + count);
                }
            }
            
            current = next;
        }
        
        return current;
    }
    
    // A가 이기는 경우의 수 계산
    private int countWins(Map<Integer, Integer> aSums, Map<Integer, Integer> bSums) {
        // B의 합을 정렬된 리스트로 변환
        List<Integer> bSumsList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : bSums.entrySet()) {
            int sum = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                bSumsList.add(sum);
            }
        }
        Collections.sort(bSumsList);
        
        int wins = 0;
        
        // A의 각 합에 대해 B보다 큰 경우의 수 계산
        for (Map.Entry<Integer, Integer> entry : aSums.entrySet()) {
            int aSum = entry.getKey();
            int aCount = entry.getValue();
            
            // 이분탐색으로 aSum보다 작은 B의 합 개수 찾기
            int bLowerCount = lowerBound(bSumsList, aSum);
            wins += aCount * bLowerCount;
        }
        
        return wins;
    }
    
    // 이분탐색: target보다 작은 원소의 개수
    private int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}