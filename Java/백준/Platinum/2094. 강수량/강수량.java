import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] yearArr;
    static int[] rainArr;
    static int[] rainMaxTree;
    static int leafPointer;
    
    public static void makeIndexTree() {
        leafPointer = 1;
        while (n > leafPointer) {
            leafPointer <<= 1;
        }

        int treeSize = leafPointer * 2;
        rainMaxTree = new int[treeSize];
        for (int j = 0; j < treeSize; j++) {
            rainMaxTree[j] = 0;
        }

        for (int i = 0; i < n; i++) {
            rainMaxTree[leafPointer + i] = rainArr[i];
        }
        
        for (int k = leafPointer - 1; k > 0; k--) {
            rainMaxTree[k] = Math.max(rainMaxTree[2 * k], rainMaxTree[2 * k + 1]);
        }
    }
    
    public static boolean isLeftChild(int idx) {
        return idx % 2 == 0;
    }
    
    public static int findMaxValue(int leftIdx, int rightIdx) {
        int maxRain = 0;
        leftIdx = leftIdx + leafPointer;
        rightIdx = rightIdx + leafPointer;

        while (rightIdx > leftIdx) {
            if (!isLeftChild(leftIdx)) {
                maxRain = Math.max(maxRain, rainMaxTree[leftIdx]);
                leftIdx++;
            }
            if (isLeftChild(rightIdx)) {
                maxRain = Math.max(maxRain, rainMaxTree[rightIdx]);
                rightIdx--;
            }
            leftIdx >>>= 1;
            rightIdx >>>= 1;
        }
        
        if (rightIdx == leftIdx) {
            maxRain = Math.max(maxRain, rainMaxTree[rightIdx]);
        }

        return maxRain;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        yearArr = new int[n];
        rainArr = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            yearArr[i] = Integer.parseInt(st.nextToken());
            rainArr[i] = Integer.parseInt(st.nextToken());
        }

        makeIndexTree();
        m = Integer.parseInt(br.readLine());

        for (int j = 0; j < m; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startYear = Integer.parseInt(st.nextToken());
            int endYear = Integer.parseInt(st.nextToken());

            int startYearIdx = Arrays.binarySearch(yearArr, startYear);
            int endYearIdx = Arrays.binarySearch(yearArr, endYear);
            
            if (startYearIdx < 0 && endYearIdx < 0) {
                sb.append("maybe\n");
            }
            else if (startYearIdx >= 0 && endYearIdx < 0) {
                endYearIdx = Math.abs(endYearIdx) - 2;
                
                if (startYearIdx >= endYearIdx) {
                    sb.append("maybe\n");
                    continue;
                }

                int startYearRain = rainArr[startYearIdx];
                int maxInRange = findMaxValue(startYearIdx + 1, endYearIdx);

                if (startYearRain > maxInRange) {
                    sb.append("maybe\n");
                } else {
                    sb.append("false\n");
                }
            }
            else if (startYearIdx < 0 && endYearIdx >= 0) {
                startYearIdx = Math.abs(startYearIdx) - 1;

                if (startYearIdx >= endYearIdx) {
                    sb.append("maybe\n");
                    continue;
                }
                
                int endYearRain = rainArr[endYearIdx];
                int maxInRange = findMaxValue(startYearIdx, endYearIdx - 1);

                if (endYearRain > maxInRange) {
                    sb.append("maybe\n");
                } else {
                    sb.append("false\n");
                }
            }

            else if (startYearIdx >= 0 && endYearIdx >= 0) {
                int startYearRain = rainArr[startYearIdx];
                int endYearRain = rainArr[endYearIdx];
                int indexDiff = endYearIdx - startYearIdx;
                int yearDiff = endYear - startYear;

                if (endYearRain > startYearRain) {
                    sb.append("false\n");
                    continue;
                }

                if (indexDiff == 1) {
                    if (indexDiff == yearDiff) {
                        sb.append("true\n");
                    } else {
                        sb.append("maybe\n");
                    }
                    continue;
                }
                
                int maxInRange = findMaxValue(startYearIdx + 1, endYearIdx - 1);
                if (maxInRange >= endYearRain) {
                    sb.append("false\n");
                    continue;
                }
                
                if (indexDiff == yearDiff) {
                    sb.append("true\n");
                } else {
                    sb.append("maybe\n");
                }
            }
        }

        System.out.print(sb);
    }
}